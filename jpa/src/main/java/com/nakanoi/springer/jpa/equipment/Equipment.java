package com.nakanoi.springer.jpa.equipment;

import com.nakanoi.springer.jpa.room.Room;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/** Simple equipment entity. */
@Entity
@Table(name = "jpa_equipments")
public class Equipment {
  @Id
  @GeneratedValue
  @Column(name = "equipment_id")
  private Integer equipmentId;

  @Column(name = "equipment_name")
  private String equipmentName;

  @ManyToOne
  @JoinColumn(name = "room_id")
  private Room room;

  @Column(name = "equipment_count")
  private Integer equipmentCount;

  @Column(name = "equipment_remarks")
  private String equipmentRemarks;

  public Integer getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(Integer equipmentId) {
    this.equipmentId = equipmentId;
  }

  public String getEquipmentName() {
    return equipmentName;
  }

  public void setEquipmentName(String equipmentName) {
    this.equipmentName = equipmentName;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public Integer getEquipmentCount() {
    return equipmentCount;
  }

  public void setEquipmentCount(Integer equipmentCount) {
    this.equipmentCount = equipmentCount;
  }

  public String getEquipmentRemarks() {
    return equipmentRemarks;
  }

  public void setEquipmentRemarks(String equipmentRemarks) {
    this.equipmentRemarks = equipmentRemarks;
  }
}
