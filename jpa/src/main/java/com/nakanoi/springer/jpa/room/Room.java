package com.nakanoi.springer.jpa.room;

import com.nakanoi.springer.jpa.equipment.Equipment;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/** Simple room entity. */
@Entity
@Table(name = "jpa_rooms")
@EntityListeners(AuditingEntityListener.class)
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

  @CreatedBy
  @Column(name = "created_by")
  private String createdBy;

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

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }
}
