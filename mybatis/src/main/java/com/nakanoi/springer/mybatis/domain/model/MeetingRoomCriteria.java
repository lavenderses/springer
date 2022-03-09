package com.nakanoi.springer.mybatis.domain.model;

/** Simple criteria for room. */
public class MeetingRoomCriteria {
  private Integer capacity;

  public MeetingRoomCriteria() {}

  public MeetingRoomCriteria(Integer capacity) {
    this.capacity = capacity;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }
}
