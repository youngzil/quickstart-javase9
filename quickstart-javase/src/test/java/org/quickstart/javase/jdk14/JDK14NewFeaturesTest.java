package org.quickstart.javase.jdk14;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.quickstart.javase.WeekDay;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2020/5/1 15:54
 */
public class JDK14NewFeaturesTest {

  @Test
  public void testInstanceof() {

    Object obj = "yangzl";

    //以前的
    if (obj instanceof String) {
      String s = (String) obj;
      boolean dd = s.contains("yang");
      System.out.println(dd);
      // use s
    }

    //jdk14
    if (!(obj instanceof String s)) {
      System.out.println(obj + " is not String");
    } else {
      System.out.println(obj + " is  String type");

      // 直接使用s，不需要转换
      boolean dd = s.contains("yang");
      System.out.println(dd);
    }
  }

  @Test
  public void testSwitchExpressions() {

    WeekDay day = WeekDay.TUESDAY;

    // Before Java 14
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

    switch (day) {
      case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
      case TUESDAY -> System.out.println(7);
      case THURSDAY, SATURDAY -> System.out.println(8);
      case WEDNESDAY -> System.out.println(9);
    }


  }

  @Test
  public void testTextBlocks() {

    // “\” 主要是用来明确标明换行的位置及之前的内容，主要是保留行末的空格
    String text = """
        Lorem ipsum dolor sit amet, consectetur adipiscing \
        elit, sed do eiusmod tempor incididunt ut labore \
        et dolore magna aliqua.\
        """;

    // “\s” 就是代表一个空格，有些场景需要用空格补足字符长度到定长
    String colors = """
        red  \s
        green\s
        blue \s
        """;
  }

  @Test
  public void testNullPointerExceptions() {

    // 空指针异常的异常信息优化，具体指明哪个对象或者对象中的哪个参数是null的，这个点对于排查定位问题比较有帮助，特别是代码中有这样的a.b.c.d.e.XXX这样的写法的时候，之前空指针只能说哪一行抛了，但是不能识别到是a或b或c或d空指针了；

    List<String> list = Arrays.asList("yang", "chen", "zhang", "wang");
    list.get(0).substring(4, 5).endsWith("test");

  }

  @Test
  public void testPackagingTool() {

    /*jpackage --input target/ \
    --name JPackageDemoApp \
    --main-jar JPackageDemoApp.jar \
    --main-class com.baeldung.java14.jpackagedemoapp.JPackageDemoApp \
    --type dmg \
    --java-options '--enable-preview'*/

    // PackagingTool  提供可以把代码打成在各个操作系统平台运行的文件格式，简化运行、部署
    // jpackage --name myapp --input lib --main-jar main.jar
    // jpackage --name myapp --module-path lib -m myapp
    // jpackage --name myapp --module-path lib -m myapp --type dmg

    // 可以通过 --type 来指定打包之后的格式，比如上述命令后面加入  --type dmg ，就是打包出 dmg 格式的安装包；

    // 这个工具可以支持 Windows 下的 msi 和 exe 格式、 linux 下的 dep 和 rpm 格式以及 Mac 下的 pkg 和 dmg 格式，
    // 这里除了打包之后有一个通用的系统的安装体验之外，还能将一些 main 函数启动的初始入参固化到打包之后的文件中。

  }


}
