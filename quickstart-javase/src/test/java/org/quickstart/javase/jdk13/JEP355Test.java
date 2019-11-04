package org.quickstart.javase.jdk13;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2019/11/4 09:53
 */
public class JEP355Test {

  public static void main(String[] args) {

    // normal String concat
    String html1 = "<html>\n" +
        "    <body>\n" +
        "        <p>Hello, <strong>concatenated string</strong></p>\n" +
        "    </body>\n" +
        "</html>\n";
    System.out.println(html1);

    // Using text blocks
    String html2 = """
                      <html>
                          <body>
                              <p>Hello, <strong>text blocks</strong></p>
                          </body>
                      </html>
                      """;
    System.out.println(html2);

    // normal String concat
    String sql1 = "SELECT STREET_NAME, BUILDING_NAME \n" +
        "FROM TBL_POSTAL_CODE \n" +
        "WHERE POSTAL_CODE = ?\n";
    System.out.println(sql1);

    // Using text blocks
    String sql2 = """
               SELECT STREET_NAME, BUILDING_NAME
               FROM TBL_POSTAL_CODE
               WHERE POSTAL_CODE = ?
               """;
    System.out.println(sql2);
  }

}
