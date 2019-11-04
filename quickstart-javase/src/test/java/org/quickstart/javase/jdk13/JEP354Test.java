package org.quickstart.javase.jdk13;

import java.time.LocalDate;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2019/11/4 09:53
 */
public class JEP354Test {
  public static void main(String[] args) {

    LocalDate now = LocalDate.now();
    final int day = now.getDayOfWeek().getValue();

    // traditional switch
    switch (day) {
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
        System.out.println("weekday");
        break;
      case 7:
      case 1:
        System.out.println("weekend");
        break;
      default:
        System.out.println("invalid");
    }

    // case L -> syntax
    // no break necessary, only code next to -> runs
    switch (day) {
      case 2, 3, 4, 5, 6 -> System.out.println("weekday");
      case 7, 1 -> System.out.println("weekend");
      default -> System.out.println("invalid");
    }

    // switch expression
    // then switch should be exhaustive if used as expression
    // using yield for yielding a value from a switch expression
    final String attr = switch (day) {
      case 2, 3, 4, 5, 6: yield "weekday";
      case 7, 1: yield "weekend";
      default: yield "invalid";
    };

    System.out.println(attr);
  }

}
