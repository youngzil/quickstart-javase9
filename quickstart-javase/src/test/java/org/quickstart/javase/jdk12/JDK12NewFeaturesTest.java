package org.quickstart.javase.jdk12;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2019/11/4 10:45
 */
public class JDK12NewFeaturesTest {

    @Test
    public void testTransform() {

        // transform：即字符串转换

        System.out.println("======test java 12 transform======");
        List<String> list1 = List.of("Java", " Python", " C++ ");
        List<String> list2 = new ArrayList<>();

        list1.forEach(element ->//
            list2.add(element.transform(String::strip)//
                .transform(String::toUpperCase)//
                .transform((e) -> "Hi," + e)));

        list2.forEach(System.out::println);
    }

    @Test
    public void testindent() {

        // 换行符 \n 后前缩进 N 个空格，为 0 或负数不缩进。

        // 其实就是调用了 lines() 方法来创建一个 Stream，然后再往前拼接指定数量的空格。
        System.out.println("======test java 12 indent======");
        String result = "Java\n Python\nC++".indent(3);
        System.out.println(result);
    }

    @Test
    public void testDescribeConstable() {
        // 很简单，其实就是调用 Optional.of 方法返回一个 Optional 类型，
        System.out.println("======test java 12 describeConstable======");
        String name = "Java技术栈";
        Optional<String> optional = name.describeConstable();
        System.out.println(optional.get());
    }

    public enum Status {
        OPEN,
        INIT,
        PROCESS,
        PENDING,
        CLOSE;
    }

    // Java 12 之前是这样用的：
    @Test
    public void testSwitch1(Status status) {
        int result = 0;
        switch (status) {
            case OPEN:
                result = 1;
                break;
            case PROCESS:
                result = 2;
                break;
            case PENDING:
                result = 2;
                break;
            case CLOSE:
                result = 3;
                break;
            default:
                throw new RuntimeException("状态不正确");
        }
        System.out.println("result is " + result);
    }

    // Java 12 后可以这样用：
    // Java 12 switch 有以下几点特色：
    // 箭头语法 ->，类似 Java 8 中的 Lambda 表达式；
    // 可以直接返回值给一个变量，并且可以不用 break 关键字；
    // case 条件，多个可以写在一行，用逗号分开；
    // 可以省略 break 关键字；
    @Test
    public void testSwitch2(Status status) {
        var result = switch (status) {
            case OPEN -> 1;
            case PROCESS, PENDING -> 2;
            case CLOSE -> 3;
            default -> throw new RuntimeException("状态不正确");
        };
        System.out.println("result is " + result);
    }

    // 比对两个文件中的内容一样

    @Test
    public void testCompareFile() throws IOException {
        Path dir = Paths.get("d:/");

        Path path1 = dir.resolve("javastack1.txt");

        Path path2 = dir.resolve("javastack2.txt");

        long result = Files.mismatch(path1, path2);

        System.out.println(result);

        // 返回-1：同一文件，或者两个文件内容一样
        // 返回其他数字：文件内容对比差异的位置，从0开始
        // 所以，只要返回 -1，说明文件内容相同。
    }

}
