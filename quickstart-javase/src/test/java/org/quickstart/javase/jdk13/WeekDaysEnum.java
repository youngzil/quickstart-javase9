package org.quickstart.javase.jdk13;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2019/11/4 09:21
 */
public enum WeekDaysEnum {

  MONDAY(1, "周一"), TUESDAY(2, "周二"), WEDNESDAY(3, "周三"), THURSDAY(4, "周四"), FRIDAY(5, "周五"), SATURDAY(6, "周六"), SUNDAY(7, "周日");

  private int typeId;
  private String typeName;

  WeekDaysEnum(int typeId, String typeName) {
    this.typeId = typeId;
    this.typeName = typeName;
  }

  public int getTypeId() {
    return typeId;
  }

  public String getTypeName() {
    return typeName;
  }

}
