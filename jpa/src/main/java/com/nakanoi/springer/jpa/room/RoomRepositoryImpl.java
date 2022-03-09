package com.nakanoi.springer.jpa.room;

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
