package com.nakanoi.springer.access;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

  /**
   * Get room by room ID with RoomRowMapper.
   *
   * @param roomId Room ID string.
   * @return Room object.
   */
  public Room getRoomByIdWithMapper(String roomId) {
    String sql = "SELECT room_id, room_name, capacity FROM rooms WHERE room_id = ?";
    RoomRowMapper mapper = new RoomRowMapper();
    return jdbcTemplate.queryForObject(sql, mapper, roomId);
  }

  /**
   * Get all rooms with RoomRowMapper.
   *
   * @return List of room objects.
   */
  public List<Room> getAllRoomsWithMapper() {
    String sql = "SELECT room_id, room_name, capacity FROM rooms";
    RoomRowMapper mapper = new RoomRowMapper();
    return jdbcTemplate.query(sql, mapper);
  }

  /**
   * Get all rooms with lambda mapper.
   *
   * @return List of room objects.
   */
  public List<Room> getAllRoomsWithLambda() {
    String sql = "SELECT room_id, room_name, capacity FROM rooms";
    return jdbcTemplate.query(
        sql,
        (rs, roomNum) -> {
          Room room = new Room();
          room.setRoomId(rs.getString("room_id"));
          room.setRoomName(rs.getString("room_name"));
          room.setCapacity(rs.getInt("capacity"));
          return room;
        });
  }

  /**
   * Get room by room ID with BeanPropertyMapper.
   *
   * @param roomId Room ID string.
   * @return Room object.
   */
  public Room getRoomByIdWithBean(String roomId) {
    String sql = "SELECT room_id, room_name, capacity FROM rooms WHERE room_id = ?";
    RowMapper<Room> mapper = new BeanPropertyRowMapper<>(Room.class);
    return jdbcTemplate.queryForObject(sql, mapper, roomId);
  }

  /**
   * Get all rooms with their equipments.
   *
   * @return List of room objects with their equipments.
   */
  public List<Room> getAllRoomsWithEquipment() {
    String sql =
        "SELECT r.room_id, r.room_name, r.capacity, e.equipment_id, e.equipment_name, "
            + "e.equipment_count, e.equipment_remarks "
            + "FROM rooms r LEFT JOIN equipments e ON r.room_id = e.room_id";
    RoomResultSetExtractor extractor = new RoomResultSetExtractor();
    return jdbcTemplate.query(sql, extractor);
  }

  /**
   * Get room with its equipments by room ID.
   *
   * @param roomId Room ID string.
   * @return Room with its equipments.
   */
  public Room getRoomByIdWithEquipment(String roomId) {
    String sql =
        "SELECT r.room_id, r.room_name, r.capacity, e.equipment_id, e.equipment_name, "
            + "e.equipment_count, e.equipment_remarks "
            + "FROM rooms r LEFT JOIN equipments e ON r.room_id = e.room_id WHERE r.room_id = ?";
    RoomResultSetExtractor extractor = new RoomResultSetExtractor();
    List<Room> rooms = jdbcTemplate.query(sql, extractor, roomId);
    if (rooms == null) {
      return null;
    }
    return rooms.get(0);
  }

  public int insertRoom(Room room) {
    String sql = "INSERT INTO rooms (room_id, room_name, capacity) VALUES (?, ?, ?)";
    return jdbcTemplate.update(sql, room.getRoomId(), room.getRoomName(), room.getCapacity());
  }

  public int updateRoomById(Room room) throws NotFoundRoomIdException {
    String sql = "UPDATE rooms SET room_name=?, capacity=? WHERE room_id=?";
    try {
      getRoomById(room.getRoomId());
    } catch (DataRetrievalFailureException e) {
      throw new NotFoundRoomIdException("Room ID = " + room.getRoomId() + " not found.");
    }
    return jdbcTemplate.update(sql, room.getRoomName(), room.getCapacity(), room.getRoomId());
  }

  public int deleteRoomById(Room room) {
    String sql = "DELETE FROM rooms WHERE room_id=?";
    return jdbcTemplate.update(sql, room.getRoomId());
  }

  /** Report all rooms to csv. */
  public void reportRooms() {
    String sql = "SELECT room_id, room_name, capacity FROM rooms";
    RoomRowCallbackHandler handler = new RoomRowCallbackHandler();
    jdbcTemplate.query(sql, handler);
  }

  /**
   * Insert equipment record.
   *
   * @param e Equipment to be inserted.
   */
  public void insertEquipment(Equipment e) {
    String sql =
        "INSERT INTO equipments (equipment_id, equipment_name, equipment_count, equipment_remarks) "
            + "VALUES (?, ?, ?, ?)";
    jdbcTemplate.update(
        sql,
        e.getEquipmentId(),
        e.getEquipmentName(),
        e.getEquipmentCount(),
        e.getEquipmentRemarks());
  }
}
