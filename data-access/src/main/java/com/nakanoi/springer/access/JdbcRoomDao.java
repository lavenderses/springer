package com.nakanoi.springer.access;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Simple room dao. */
@Component
public class JdbcRoomDao {
  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  JdbcRoomDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  public int findMaxCapacity() throws NullPointerException {
    String sql = "SELECT MAX(capacity) FROM rooms";
    return jdbcTemplate.queryForObject(sql, Integer.class);
  }

  public String findRoomNameById(String roomId) {
    String sql = "SELECT room_name FROM rooms WHERE room_id = ?";
    return jdbcTemplate.queryForObject(sql, String.class, roomId);
  }

  public String findRoomNameByIdWithNamedParameter(String roomId) {
    String sql = "SELECT room_name FROM rooms WHERE room_id = :roomId";
    Map<String, Object> params = new HashMap<>();
    params.put("roomId", roomId);
    return namedParameterJdbcTemplate.queryForObject(sql, params, String.class);
  }

  public String findRoomNameByIdWithMapSql(String roomId) {
    String sql = "SELECT room_name FROM rooms WHERE room_id = :roomId";
    MapSqlParameterSource map = new MapSqlParameterSource()
        .addValue("roomId", roomId);
    return namedParameterJdbcTemplate.queryForObject(sql, map, String.class);
  }

  public String findRoomNameByIdWithBean(String roomId) {
    String sql = "SELECT room_name FROM rooms WHERE room_id = :roomId";
    Room room = new Room("A001", "Official meeting", 10);
    BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(room);
    return namedParameterJdbcTemplate.queryForObject(sql, map, String.class);
  }

  public Room getRoomById(String roomId) {
    String sql = "SELECT room_id, room_name, capacity FROM rooms WHERE room_id = ?";
    Map<String, Object> result = jdbcTemplate.queryForMap(sql, roomId);
    Room room = new Room();
    room.setRoomId((String) result.get("room_id"));
    room.setRoomName((String) result.get("room_name"));
    room.setCapacity((int) result.get("capacity"));
    return room;
  }

  public List<Room> getAllRooms() {
    String sql = "SELECT room_id, room_name, capacity FROM rooms";
    List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
    List<Room> rooms = new ArrayList<>();
    results.forEach(result -> {
      Room room = new Room();
      room.setRoomId((String) result.get("room_id"));
      room.setRoomName((String) result.get("room_name"));
      room.setCapacity((int) result.get("capacity"));
      rooms.add(room);
    });
    return rooms;
  }

  public int insertRoom(Room room) {
    String sql = "INSERT INTO rooms (room_id, room_name, capacity) VALUES (?, ?, ?)";
    return jdbcTemplate.update(sql, room.getRoomId(), room.getRoomName(), room.getCapacity());
  }

  public int updateRoomById(Room room) {
    String sql = "UPDATE rooms SET room_name=?, capacity=? WHERE room_id=?";
    return jdbcTemplate.update(sql, room.getRoomName(), room.getCapacity(), room.getRoomId());
  }

  public int deleteRoomById(Room room) {
    String sql = "DELETE FROM rooms WHERE room_id=?";
    return jdbcTemplate.update(sql, room.getRoomId());
  }
}
