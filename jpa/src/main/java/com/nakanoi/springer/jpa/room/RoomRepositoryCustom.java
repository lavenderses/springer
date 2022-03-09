package com.nakanoi.springer.jpa.room;

import java.util.List;

/** Simple custom room repository. */
public interface RoomRepositoryCustom {
  List<Room> findByCriteria(RoomCriteria roomCriteria);
}
