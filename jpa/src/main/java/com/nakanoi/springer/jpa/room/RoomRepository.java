package com.nakanoi.springer.jpa.room;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.List;

/** Simple room repository interface. */
public interface RoomRepository extends JpaRepository<Room, Integer>, RoomRepositoryCustom {
  @Lock(LockModeType.OPTIMISTIC)
  @Query("SELECT r FROM Room r WHERE r.roomName = :roomName")
  List<Room> findByRoomName(@Param("roomName") String roomName);

  @Query("SELECT r FROM Room r WHERE r.roomName = :roomName")
  Page<Room> findByRoomNameWithPage(@Param("roomName") String roomName, Pageable pageable);

  @Query("UPDATE Room r SET r.capacity = :capacity")
  Integer updateCapacityAll(@Param("capacity") Integer capacity);
}
