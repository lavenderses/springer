package com.nakanoi.springer.transaction;

import com.nakanoi.springer.access.JdbcRoomDao;
import com.nakanoi.springer.access.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Room service interface implementation. */
@Transactional
@Service("roomService")
public class RoomServiceImpl implements RoomService {
  private final JdbcRoomDao jdbcRoomDao;

  RoomServiceImpl(JdbcRoomDao jdbcRoomDao) {
    this.jdbcRoomDao = jdbcRoomDao;
  }

  @Override
  @Transactional(readOnly = true)
  public Room getRoom(String roomId) {
    return jdbcRoomDao.getRoomById(roomId);
  }

  @Override
  public void insertRoom(Room room) {
    jdbcRoomDao.insertRoom(room);
    room.getEquipmentList().forEach(jdbcRoomDao::insertEquipment);
  }
}
