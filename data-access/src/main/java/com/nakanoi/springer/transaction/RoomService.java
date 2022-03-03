package com.nakanoi.springer.transaction;

import com.nakanoi.springer.access.Room;

/** Room service interface. */
public interface RoomService {
  Room getRoom(String roomId);

  void insertRoom(Room room);
}
