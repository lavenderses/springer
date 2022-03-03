package com.nakanoi.springer.transaction;

import com.nakanoi.springer.access.JdbcRoomDao;
import com.nakanoi.springer.access.Room;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** Main application class. */
public class Main {

  /**
   * Main method.
   *
   * @param args Application arguments.
   */
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);
    JdbcRoomDao roomDao = context.getBean("jdbcRoomDao", JdbcRoomDao.class);
    RoomServiceImpl serviceDao = context.getBean("roomService", RoomServiceImpl.class);
    RoomServiceTxImpl serviceDaoWithTx =
        context.getBean("roomServiceWithClearTx", RoomServiceTxImpl.class);
    RoomServiceTemplateImpl serviceDaoWithTemplate =
        context.getBean("roomServiceWithTransactionTemplate", RoomServiceTemplateImpl.class);

    Room room = new Room("XYZ001", "Entrance", 35);
    serviceDao.insertRoom(room);
    serviceDao.getRoom(room.getRoomId());
    roomDao.deleteRoomById(room);

    serviceDaoWithTx.insertRoom(room);
    serviceDaoWithTx.getRoom(room.getRoomId());
    roomDao.deleteRoomById(room);

    serviceDaoWithTemplate.insertRoom(room);
    serviceDaoWithTemplate.getRoom(room.getRoomId());
    roomDao.deleteRoomById(room);
  }
}
