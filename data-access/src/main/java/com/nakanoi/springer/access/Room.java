package com.nakanoi.springer.access;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Simple room object. */
public class Room {
  private String roomId;
  private String roomName;
  private int capacity;
  private List<Equipment> equipmentList;

  public Room() {
    equipmentList = new ArrayList<>();
  }

  /**
   * Room constructor with constructor args.
   *
   * @param roomId Room ID string which is unique.
   * @param roomName Room name string.
   * @param capacity Room capacity.
   */
  public Room(String roomId, String roomName, int capacity) {
    this.roomId = roomId;
    this.roomName = roomName;
    this.capacity = capacity;
    equipmentList = new ArrayList<>();
  }

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public List<Equipment> getEquipmentList() {
    return Collections.unmodifiableList(equipmentList);
  }

  public void addEquipmentList(Equipment equipment) {
    this.equipmentList.add(equipment);
  }

  @Override
  public String toString() {
    return String.format(
        "Room {roomId='%s', roomName='%s', capacity=%d, equipments=%s}",
        roomId, roomName, capacity, equipmentList);
  }
}
