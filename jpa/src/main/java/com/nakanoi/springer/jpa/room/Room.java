package com.nakanoi.springer.jpa.room;

import com.nakanoi.springer.jpa.equipment.Equipment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import java.io.Serializable;
import java.util.List;

/** Simple room entity. */
@Entity
@Table(name = "jpa_rooms")
public class Room implements Serializable {
  @Id
  @GeneratedValue
  @Column(name = "room_id")
  private Integer roomId;

  @Column(name = "room_name")
  private String roomName;

  @Column(name = "capacity")
  private Integer capacity;

  @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Equipment> equipments;

  @Version
  @Column(name = "version")
  private Integer version;

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
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

  public List<Equipment> getEquipments() {
    return equipments;
  }

  public void setEquipments(List<Equipment> equipments) {
    this.equipments = equipments;
  }
}
