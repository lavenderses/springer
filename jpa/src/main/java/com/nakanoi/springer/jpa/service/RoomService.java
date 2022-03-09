package com.nakanoi.springer.jpa.service;

import com.nakanoi.springer.jpa.room.Room;

/** Simple room service interface. */
public interface RoomService {
  public Room getRoom(Integer id);

  public Room createRoom(String roomName, Integer capacity);

  public Room updateRoom(Integer id, String roomName);

  public void deleteRoom(Integer id);
}
