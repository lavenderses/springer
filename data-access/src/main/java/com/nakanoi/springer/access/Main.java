package com.nakanoi.springer.access;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** Simple main class. */
public class Main {
  /**
   * Main execution of data access.
   *
   * @param args arguments.
   */
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(DataAccessConfig.class);
    JdbcRoomDao dao = context.getBean("jdbcRoomDao", JdbcRoomDao.class);
    String roomId = "A001";

    dao.findMaxCapacity();
    dao.findRoomNameById(roomId);
    dao.findRoomNameByIdWithNamedParameter(roomId);
    dao.findRoomNameByIdWithMapSql(roomId);
    dao.findRoomNameByIdWithBean(roomId);

    dao.getRoomById(roomId);
    dao.getAllRooms();

    Room newRoom = new Room("S001", "Gym", 50);
    Room updateRoom = new Room("S001", "Sports Gym", 400);
    dao.insertRoom(newRoom);
    dao.updateRoomById(updateRoom);
    dao.deleteRoomById(newRoom);

    dao.getRoomByIdWithMapper(roomId);
    dao.getAllRoomsWithMapper();
    dao.getAllRoomsWithLambda();
    dao.getRoomByIdWithBean(roomId);

    dao.getAllRoomsWithEquipment();
    dao.getRoomByIdWithEquipment(roomId);
    dao.reportRooms();

    // THROWS EXCEPTION
    // updateRoom.setRoomId("NOT EXISTING ROOM ID");
    // dao.updateRoomById(updateRoom);
  }
}
