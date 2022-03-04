package com.nakanoi.springer.transaction;

import com.nakanoi.springer.access.JdbcRoomDao;
import com.nakanoi.springer.access.Room;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/** Room service implementation with clear tx. */
@Service("roomServiceWithClearTx")
public class RoomServiceTxImpl implements RoomService {
  private final PlatformTransactionManager txManager;
  private final JdbcRoomDao roomDao;

  RoomServiceTxImpl(PlatformTransactionManager txManager, JdbcRoomDao roomDao) {
    this.txManager = txManager;
    this.roomDao = roomDao;
  }

  @Override
  public Room getRoom(String roomId) {
    return roomDao.getRoomById(roomId);
  }

  @Override
  public void insertRoom(Room room) {
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("InsertRoomWithEquipmentTx");
    def.setReadOnly(false);
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    TransactionStatus status = txManager.getTransaction(def);

    try {
      roomDao.insertRoom(room);
      room.getEquipmentList().forEach(roomDao::insertEquipment);
    } catch (Exception e) {
      txManager.rollback(status);
      throw new DataAccessException("Error occurred.", e) {};
    }
    txManager.commit(status);
  }
}
