package org.quickstart.javase;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2020/5/1 16:10
 */
public enum WeekDay {

  SUNDAY {
    @Override
    public String getLocalValue() {
      return "星期日";
    }
  },
  MONDAY {
    @Override
    public String getLocalValue() {
      // TODO Auto-generated method stub
      return "星期一";
    }
  },
  TUESDAY {
    @Override
    public String getLocalValue() {
      // TODO Auto-generated method stub
      return "星期二";
    }
  },
  WEDNESDAY {
    @Override
    public String getLocalValue() {
      // TODO Auto-generated method stub
      return "星期三";
    }
  },
  THURSDAY {
    @Override
    public String getLocalValue() {
      // TODO Auto-generated method stub
      return "星期四";
    }
  },
  FRIDAY {
    @Override
    public String getLocalValue() {
      // TODO Auto-generated method stub
      return "星期五";
    }
  },
  SATURDAY {
    @Override
    public String getLocalValue() {
      // TODO Auto-generated method stub
      return "星期六";
    }
  };

  public abstract String getLocalValue();

}


