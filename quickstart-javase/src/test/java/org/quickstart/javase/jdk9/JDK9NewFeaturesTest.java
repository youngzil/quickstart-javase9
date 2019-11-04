package org.quickstart.javase.jdk9;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2019/11/4 10:44
 */
public class JDK9NewFeaturesTest {

  @Test
  public void testMap() {
    // java6及以前
    Map<String, String> map7 = new HashMap<String, String>();
    // java7和8 <>没有了数据类型
    Map<String, String> map8 = new HashMap<>();
    // java9 添加了匿名内部类的功能 后面添加了大括号{} 可以做一些细节的操作
    Map<String, String> map9 = new HashMap<>() {
    };
  }

  @Test
  public void testStreamAPI() {

    List<Integer> list = Arrays.asList(45, 43, 76, 87, 42, 90, 73, 67);

    // list.stream().takeWhile(x->x<50).forEach(System.out::println);
    // 而 dropWhile 则和takeWhile 相反

    // 原来的控制终止方式
    Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);

    // jdk9中
    // Stream.iterate(1,i<100,i->i+1).forEach(System.out::println);

  }

  @Test
  public void testCatchException() {

    // Java6处理方式：
    // java7及以前写法 每一个流打开的时候都要关闭
    InputStreamReader reader = null;
    try {
      reader = new InputStreamReader(System.in);
      reader.read();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    // JDK7,8 共同的处理方式：
    // java7和8及 每一个流打开的时候都要关闭,但是在try的括号中来进行关闭
    try (InputStreamReader reader8 = new InputStreamReader(System.in)) {
      reader8.read();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // java9的处理方式：
    // java9及 每一个流打开的时候都要关闭,但是在try的括号中来进行关闭，在java8的基础上进一步升级 直接在try括号中直接写入 变量就好，如果有多个流，就用分号隔开
    // try(reader;writer){}
    InputStreamReader reader9 = new InputStreamReader(System.in);
    try (reader9) {
      reader9.read();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
