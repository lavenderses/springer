package com.nakanoi.springer.jpa.repository;

import com.nakanoi.springer.jpa.room.Room;
import com.nakanoi.springer.jpa.room.RoomCriteria;
import java.util.List;

/** Simple custom room repository. */
public interface RoomRepositoryCustom {
  List<Room> findByCriteria(RoomCriteria roomCriteria);
}
