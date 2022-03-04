package com.nakanoi.springer.transaction;

import com.nakanoi.springer.access.JdbcRoomDao;
import com.nakanoi.springer.access.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/** Room service implementation with transaction template. */
@Service("roomServiceWithTransactionTemplate")
public class RoomServiceTemplateImpl implements RoomService {
  private final TransactionTemplate transactionTemplate;
  private final JdbcRoomDao roomDao;

  RoomServiceTemplateImpl(TransactionTemplate transactionTemplate, JdbcRoomDao roomDao) {
    this.transactionTemplate = transactionTemplate;
    this.roomDao = roomDao;
  }

  @Override
  public Room getRoom(String roomId) {
    return roomDao.getRoomById(roomId);
  }

  @Override
  public void insertRoom(Room room) {
    transactionTemplate.execute(
        new TransactionCallbackWithoutResult() {
          @Override
          protected void doInTransactionWithoutResult(TransactionStatus status) {
            roomDao.insertRoom(room);
            room.getEquipmentList().forEach(roomDao::insertEquipment);
          }
        });
  }
}
