package com.nakanoi.springer.jpa.repository;

import com.nakanoi.springer.jpa.room.Room;
import com.nakanoi.springer.jpa.room.RoomCriteria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/** Simple implementation for room repository custom. */
public class RoomRepositoryImpl implements RoomRepositoryCustom {
  @PersistenceContext private EntityManager entityManager;

  @Override
  public List<Room> findByCriteria(RoomCriteria roomCriteria) {
    return null;
  }
}
