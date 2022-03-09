package com.nakanoi.springer.jpa.room;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

/** Simple implementation for room repository custom. */
public class RoomRepositoryImpl implements RoomRepositoryCustom {
  @PersistenceContext private EntityManager entityManager;

  @Override
  public List<Room> findByCriteria(RoomCriteria roomCriteria) {
    return null;
  }
}
