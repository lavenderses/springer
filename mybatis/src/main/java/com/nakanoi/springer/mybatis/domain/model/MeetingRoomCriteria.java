package com.nakanoi.springer.mybatis.domain.model;

/** Simple criteria for room. */
public class MeetingRoomCriteria {
  private String roomId;
  private String roomName;
  private Integer capacity;

  public MeetingRoomCriteria() {}

  public MeetingRoomCriteria(Integer capacity) {
    this.capacity = capacity;
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

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }
}
