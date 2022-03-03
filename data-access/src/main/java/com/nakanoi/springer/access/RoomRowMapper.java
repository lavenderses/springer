package com.nakanoi.springer.access;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/** Simple row mapper. */
public class RoomRowMapper implements RowMapper<Room> {

  @Override
  public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
    Room room = new Room();
    room.setRoomId(rs.getString("room_id"));
    room.setRoomName(rs.getString("room_name"));
    room.setCapacity(rs.getInt("capacity"));
    return room;
  }
}
