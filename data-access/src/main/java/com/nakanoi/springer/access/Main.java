package com.nakanoi.springer.access;

import java.util.List;
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

    int maxCapacity = dao.findMaxCapacity();
    System.out.println(maxCapacity);
    String roomName = dao.findRoomNameById(roomId);
    System.out.println(roomName);
    roomName = dao.findRoomNameByIdWithNamedParameter(roomId);
    System.out.println(roomName);
    roomName = dao.findRoomNameByIdWithMapSql(roomId);
    System.out.println(roomName);
    roomName = dao.findRoomNameByIdWithBean(roomId);
    System.out.println(roomName);

    Room room = dao.getRoomById(roomId);
    System.out.println(room);
    List<Room> rooms = dao.getAllRooms();
    System.out.println(rooms);

    Room newRoom = new Room("S001", "Gym", 50);
    int delete = dao.deleteRoomById(newRoom);
    System.out.println(delete);
    int insert = dao.insertRoom(newRoom);
    System.out.println(insert);
    Room updateRoom = new Room("S001", "Sports Gym", 400);
    int update = dao.updateRoomById(updateRoom);
    System.out.println(update);
  }
}
