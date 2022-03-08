package com.nakanoi.springer.jpa.room;

import com.nakanoi.springer.jpa.equipment.Equipment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** Simple room repository. */
@Repository
public class RoomRepository {
  @PersistenceContext
  private final EntityManager entityManager;

  public RoomRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Transactional(readOnly = true)
  public List<Equipment> getEquipmentsInRoom(Integer roomId) {
    Room room = entityManager.find(Room.class, roomId);
    return room.getEquipments();
  }

  @Transactional(readOnly = true)
  public Room getRoomOfEquipment(Integer equipmentId) {
    Equipment equipment = entityManager.find(Equipment.class, equipmentId);
    return equipment.getRoom();
  }

  @Transactional(readOnly = true)
  public List<Room> getRoomsByName(String roomName) {
    String jpql = "SELECT r FROM Room r WHERE r.roomName = :roomName";
    TypedQuery<Room> query = entityManager.createQuery(jpql, Room.class);
    query.setParameter("roomName", roomName);
    return query.getResultList();
  }

  @Transactional
  public void updateRoomWithOptimisticLock(Integer id, String roomName, Integer capacity) {
    Room room = entityManager.find(Room.class, id);
    entityManager.lock(room, LockModeType.OPTIMISTIC);
  }
}
