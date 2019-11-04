package org.quickstart.javase.jdk13;

import org.junit.Test;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2019/11/4 09:17
 *
 * https://my.oschina.net/mdxlcj/blog/3107021
 *
 */
public class JDK13NewFeaturesTest {

  @Test
  public void testSwitchExpressions() {
    // switch优化更新

    // JDK11以及之前的版本：
    WeekDaysEnum day = WeekDaysEnum.MONDAY;
    switch (day) {
      case MONDAY:
      case FRIDAY:
      case SUNDAY:
        System.out.println(6);
        break;
      case TUESDAY:
        System.out.println(7);
        break;
      case THURSDAY:
      case SATURDAY:
        System.out.println(8);
        break;
      case WEDNESDAY:
        System.out.println(9);
        break;
    }

    // JDK12版本
    switch (day) {
      case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
      case TUESDAY -> System.out.println(7);
      case THURSDAY, SATURDAY -> System.out.println(8);
      case WEDNESDAY -> System.out.println(9);
    }

    // JDK13版本
    System.out.println(switch (day) {
      case MONDAY -> "one";
      case TUESDAY -> "two";
      default -> "many";
    });

  }

  // JDK13版本
  static void howMany(int k) {
    System.out.println(switch (k) {
      case 1 -> "one";
      case 2 -> "two";
      default -> "many";
    });
  }

  @Test
  public  void testTextBlocks(){
    // 文本块升级

    //       2.1、html例子

    // JDK13之前
    String html = "<html>\n" +
        "    <body>\n" +
        "        <p>Hello, world</p>\n" +
        "    </body>\n" +
        "</html>\n";

    // JDK13优化的：
    String html2 = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;

    // 2.2、SQL变化

    //     JDK13之前
    String query = "SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`\n" +
        "WHERE `CITY` = 'INDIANAPOLIS'\n" +
        "ORDER BY `EMP_ID`, `LAST_NAME`;\n";

    // JDK13
    String query2 = """
                SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
                WHERE `CITY` = 'INDIANAPOLIS'
                ORDER BY `EMP_ID`, `LAST_NAME`;
               """;

    // 2.3、解释

    //     文本块
  String str =  """
line 1
line 2
line 3
""";

  // 相当于字符串文字：
    String str2 = "line 1\nline 2\nline 3\n";


  }

}
