package org.quickstart.javase.jdk10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2019/11/4 10:44
 */
public class JDK10NewFeaturesTest {

  @Test
  public void testVar(){
    var number = 10;
    var str    = "i like java";
    var list   = new ArrayList<>();
    var map    = new HashMap<>();
    var set    = new HashSet<>();

    list.add("test var is list");

    map.put("1","test var is map");

    set.add("test var is set");

    System.out.println(number);

    System.out.println(str);

    System.out.println(list.toString());

    System.out.println(map.toString());

    System.out.println(set.toString());

  }

}
