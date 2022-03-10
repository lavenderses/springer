package com.nakanoi.springer.mybatis.domain.model;

import java.time.LocalDate;

/** Simple reservable date for room. */
public class ReservableDate {
  private String roomId;
  private LocalDate reservableDate;

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  public LocalDate getReservableDate() {
    return reservableDate;
  }

  public void setReservableDate(LocalDate reservableDate) {
    this.reservableDate = reservableDate;
  }
}
