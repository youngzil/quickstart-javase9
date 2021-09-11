package org.quickstart.javase.jdk9;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public void testList() {
        var list = List.of("Java", "Python", "C");
        var copy = List.copyOf(list);
        System.out.println(list == copy);   // true

        var list2 = new ArrayList<String>();
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2);   // false

        // 注意：使用 of 和 copyOf 创建的集合为不可变集合，不能进行添加、删除、替换、排序等操作，不然会报 java.lang.UnsupportedOperationException 异常。

    }

    @Test
    public void testStreamAPI() {


        // 增加单个参数构造方法，可为null
        Stream.ofNullable(null).count(); // 0

        // 增加 takeWhile 和 dropWhile 方法
        Stream.of(1, 2, 3, 2, 1)//
            .takeWhile(n -> n < 3)//
            .collect(Collectors.toList());  // [1, 2]

        // 从开始计算，当 n < 3 时就截止。

        Stream.of(1, 2, 3, 2, 1)//
            .dropWhile(n -> n < 3)//
            .collect(Collectors.toList());  // [3, 2, 1]

        List<Integer> list = Arrays.asList(45, 43, 76, 87, 42, 90, 73, 67);

        list.stream().takeWhile(x -> x < 50).forEach(System.out::println);

        Stream.of("a", "b", "c", "", "e").takeWhile(s -> !s.isEmpty()).forEach(System.out::println);

        // 而 dropWhile 则和takeWhile 相反

        //       ofNullable, 在java8中 Stream中的元素不能完全为null，否则空指针异常，而在java9的升级中，允许创建null

        // 原来的控制终止方式
        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);
        //
        // jdk9中这个 iterate 方法的新重载方法，可以让你提供一个 Predicate (判断条件)来指定什么时候结束迭代。
        Stream.iterate(1, i -> i < 100, i -> i + 1).forEach(System.out::println);

        // Before Java 8
        // Employee emp= getEmployee(empId);
        // Stream<Roles> roles= emp== null? Stream.empty(): emp.roles();
        // In Java 9
        // Employee emp= getEmployee(empId);
        // Stream.ofNullable(emp).flatMap(Employee::roles)


        // Opthonal 也增加了几个非常酷的方法，现在可以很方便的将一个 Optional 转换成一个 Stream, 或者当一个空 java.util.Optional 时给它一个替代的。

        Optional.of("javastack").orElseThrow();     // javastack
        Optional.of("javastack").stream().count();  // 1
        Optional.ofNullable(null)//
            .or(() -> Optional.of("javastack"))//
            .get();   // javastack
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
