package com.nakanoi.springer.access;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/** Simple room dao. */
@Component
public class JdbcRoomDao {
  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  /**
   * JDBC room dao constructor.
   *
   * @param jdbcTemplate JdbcTemplate object which will be injected.
   * @param namedParameterJdbcTemplate NamedParameterJdbcTemplate object which will be injected.
   */
  JdbcRoomDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  /**
   * Find max capacity from rooms table.
   *
   * @return Max capacity or -1 if there is no records.
   */
  public int findMaxCapacity() {
    String sql = "SELECT MAX(capacity) FROM rooms";
    Object result = jdbcTemplate.queryForObject(sql, Object.class);
    if (result == null) {
      return -1;
    } else {
      return (int) result;
    }
  }

  /**
   * Find room name by room ID.
   *
   * @param roomId Room ID.
   * @return Room name string.
   */
  public String findRoomNameById(String roomId) {
    String sql = "SELECT room_name FROM rooms WHERE room_id = ?";
    return jdbcTemplate.queryForObject(sql, String.class, roomId);
  }

  /**
   * Find room name with named parameter template.
   *
   * @param roomId Room ID.
   * @return Room name string.
   */
  public String findRoomNameByIdWithNamedParameter(String roomId) {
    String sql = "SELECT room_name FROM rooms WHERE room_id = :roomId";
    Map<String, Object> params = new HashMap<>();
    params.put("roomId", roomId);
    return namedParameterJdbcTemplate.queryForObject(sql, params, String.class);
  }

  /**
   * Find room name with sql parameter mapping.
   *
   * @param roomId Room ID.
   * @return Room name string.
   */
  public String findRoomNameByIdWithMapSql(String roomId) {
    String sql = "SELECT room_name FROM rooms WHERE room_id = :roomId";
    MapSqlParameterSource map = new MapSqlParameterSource().addValue("roomId", roomId);
    return namedParameterJdbcTemplate.queryForObject(sql, map, String.class);
  }

  /**
   * Find room name with bean params mapping.
   *
   * @param roomId Room ID.
   * @return Room name string.
   */
  public String findRoomNameByIdWithBean(String roomId) {
    String sql = "SELECT room_name FROM rooms WHERE room_id = :roomId";
    Room room = new Room("A001", "Official meeting", 10);
    BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(room);
    return namedParameterJdbcTemplate.queryForObject(sql, map, String.class);
  }

  /**
   * Get room object by room ID.
   *
   * @param roomId Room ID.
   * @return Room object.
   */
  public Room getRoomById(String roomId) {
    String sql = "SELECT room_id, room_name, capacity FROM rooms WHERE room_id = ?";
    Map<String, Object> result = jdbcTemplate.queryForMap(sql, roomId);
    Room room = new Room();
    room.setRoomId((String) result.get("room_id"));
    room.setRoomName((String) result.get("room_name"));
    room.setCapacity((int) result.get("capacity"));
    return room;
  }

  /**
   * Get ALl rooms from rooms table.
   *
   * @return Room instances list.
   */
  public List<Room> getAllRooms() {
    String sql = "SELECT room_id, room_name, capacity FROM rooms";
    List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
    List<Room> rooms = new ArrayList<>();
    results.forEach(
        result -> {
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
