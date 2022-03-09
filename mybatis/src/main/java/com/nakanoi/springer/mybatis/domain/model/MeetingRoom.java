package com.nakanoi.springer.mybatis.domain.model;

import java.time.LocalDate;
import java.util.List;

/** Simple room class. */
public class MeetingRoom {
  private String roomId;
  private String roomName;
  private Integer capacity;
  private List<LocalDate> reservableDates;

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

  public List<LocalDate> getReservableDates() {
    return reservableDates;
  }

  public void setReservableDates(List<LocalDate> reservableDates) {
    this.reservableDates = reservableDates;
  }
}
