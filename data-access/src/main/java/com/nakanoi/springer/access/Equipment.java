package com.nakanoi.springer.access;

/** Simple equipment class. */
public class Equipment implements Cloneable {
  private String equipmentId;
  private String equipmentName;
  private int equipmentCount;
  private String equipmentRemarks;

  public Equipment() {}

  public String getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(String equipmentId) {
    this.equipmentId = equipmentId;
  }

  public String getEquipmentName() {
    return equipmentName;
  }

  public void setEquipmentName(String equipmentName) {
    this.equipmentName = equipmentName;
  }

  public int getEquipmentCount() {
    return equipmentCount;
  }

  public void setEquipmentCount(int equipmentCount) {
    this.equipmentCount = equipmentCount;
  }

  public String getEquipmentRemarks() {
    return equipmentRemarks;
  }

  public void setEquipmentRemarks(String equipmentRemarks) {
    this.equipmentRemarks = equipmentRemarks;
  }

  @Override
  public String toString() {
    return String.format(
        "Equipment{equipmentId='%s', equipmentName='%s',"
            + "equipmentCount='%d', equipmentRemarks='%s'}",
        equipmentId, equipmentName, equipmentCount, equipmentRemarks);
  }

  @Override
  public Equipment clone() {
    try {
      Equipment clone = (Equipment) super.clone();
      clone.setEquipmentId(this.getEquipmentId());
      clone.setEquipmentName(this.getEquipmentName());
      clone.setEquipmentCount(this.getEquipmentCount());
      clone.setEquipmentRemarks(this.getEquipmentRemarks());
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
