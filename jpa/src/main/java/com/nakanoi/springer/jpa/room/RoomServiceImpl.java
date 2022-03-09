package com.nakanoi.springer.jpa.room;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Simple room service implementation. */
@Service
public class RoomServiceImpl implements RoomService {
  private final RoomRepository roomRepository;

  public RoomServiceImpl(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Room getRoom(Integer id) {
    return roomRepository.findById(id).orElse(null);
  }

  @Override
  @Transactional
  public Room createRoom(String roomName, Integer capacity) {
    Room room = new Room();
    room.setRoomName(roomName);
    room.setCapacity(capacity);
    return roomRepository.save(room);
  }

  @Override
  @Transactional
  public Room updateRoom(Integer id, String roomName) {
    Room room = getRoom(id);
    if (room != null) {
      room.setRoomName(roomName);
    }
    return room;
  }

  @Override
  @Transactional
  public void deleteRoom(Integer id) {
    roomRepository.deleteById(id);
  }

  @Transactional(readOnly = true)
  public List<Room> getRoomsAll() {
    return roomRepository.findAll();
  }

  @Transactional(readOnly = true)
  public List<Room> getRoomsByRoomNameWithPage(String roomName, int page, int size) {
    Sort sort = Sort.by(Sort.Direction.ASC, "roomName");
    Pageable pageable = PageRequest.of(page, size, sort);
    Page<Room> rooms = roomRepository.findByRoomNameWithPage(roomName, pageable);
    return rooms.getContent();
  }
}
