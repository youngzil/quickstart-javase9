package org.quickstart.javase.jdk10;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2019/11/4 10:44
 */
public class JDK10NewFeaturesTest {

  @Test
  public void testVar() {

    // 将前端思想var关键字引入java后段，自动检测所属于类型，一种情况除外，不能为null，因为不能判断具体类型，会报异常。

    var number = 10;
    var str = "i like java";
    var list = new ArrayList<>();
    var map = new HashMap<>();
    var set = new HashSet<>();

    list.add("test var is list");

    map.put("1", "test var is map");

    set.add("test var is set");

    System.out.println(number);

    System.out.println(str);

    System.out.println(list.toString());

    System.out.println(map.toString());

    System.out.println(set.toString());

  }

  @Test
  public void testCopyOf() {

    // 在java.util.List、java.util.Set、java.util.Map新增加了一个静态方法copyOf，这些方法按照其迭代顺序返回一个不可修改的列表、集合或映射包含了给定的元素的集合。但是如果将返回后的集合继续修改，那么报异常。

    var list = new ArrayList<>();

    list.add("first");
    list.add("second");
    list.add("third");

    var result = List.copyOf(list);

    System.out.println(result.toString());
  }

  @Test
  public void testByteArrayOutputStream() throws UnsupportedEncodingException {

    // Java.io.ByteArrayOutputStream，重载toString()方法，通过使用指定的字符集编码字节，将缓冲区的内容转换为字符串，以前是默认没有参数，现在加了一个编码的字符方法。

    String str = "我喜欢java";
    ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("utf-8"));

    ByteArrayOutputStream bos = new ByteArrayOutputStream();

    int c = 0;
    while ((c = bis.read()) != -1) {
      bos.write(c);
    }
    //bos.toString() 默认的使用的UTF-8编码
    System.out.println(bos.toString());

  }


  @Test
  public void testPrintStream() throws FileNotFoundException, UnsupportedEncodingException {
    // PrintStream、PrintWriter
    // Java.io.PrintStream,Java.io.PrintWriter，这两个类都有三个新的构造方法，他们需要而外的参数charset

    String str = "我也特别喜欢java";
    var pri = new PrintWriter("/Users/tentsuuhou/Desktop/11.txt");
    pri.println(str);
    pri.flush();
    pri.close();
  }


  @Test
  public void testReader() throws IOException {
    // Reader:transferTo方法
    // Java.io.Reader:transferTo从这个Reader中读取所有字符串，并按照所读取的顺序将字符串写入给指定的Writer

    var reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/tentsuuhou/Desktop/11.txt"), "utf-8"));
    var p = new PrintWriter(new File("/Users/tentsuuhou/Desktop/12.txt"));
    reader.transferTo(p);
    p.flush();
    p.close();
    reader.close();
  }


  @Test
  public void test5() throws FileNotFoundException {
    // Formatter、Scanner
    // java.util.Formatter、java.util.Scanner新增三个构造方法，除了其他参数之外，都需要一个charset参数，将11.txt内容替换成这样

    var scan = new Scanner(new FileInputStream(new File("/Users/tentsuuhou/Desktop/11.txt")), "utf-8");
    scan.useDelimiter(" |,");
    while (scan.hasNext()) {
      System.out.println(scan.next());
    }

  }


}
