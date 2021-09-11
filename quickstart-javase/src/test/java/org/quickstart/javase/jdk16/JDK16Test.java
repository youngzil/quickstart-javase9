package org.quickstart.javase.jdk16;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JDK16Test {

    @Test
    public void testStreamCollectToList() {
        //之前的方式
        List<String> features = Stream.of("Records", "Pattern Matching", "Sealed Classes")//
            .map(String::toLowerCase)//
            .filter(s -> s.contains(" "))//
            .collect(Collectors.toList());//返回的这个列表是可修改的列表。

        // 新的方式
        List<String> features2 = Stream.of("Records", "Pattern Matching", "Sealed Classes")//
            .map(String::toLowerCase)//
            .filter(s -> s.contains(" "))//
            .toList();//返回的这个列表是一个不可修改的列表。

    }

    @Test
    public void testRecords() {

        // 记录实际上是建模不可变数据的。

        // 它也不是 JavaBeans 的直接替代品，因为正如我之前提到的，访问器这样的方法不符合 JavaBeans 的 get 标准。
        // 另外 JavaBeans 通常是可变的，而记录是不可变的。尽管它们的用途有点像，但记录并不会以某种方式取代 JavaBean。
        // 你也不应该将记录视为值类型。

        Product p1 = new Product("peanut butter", "my-vendor", 20, true);
        Product p2 = new Product("peanut butter", "my-vendor", 20, true);

        // 这两条记录是两个不同的实例，因此引用对比将给出 false。
        System.out.println(p1 == p2); // Prints false
        // 但是当我们使用 equals()时，它只查看这两个记录的值，所以它会评估为 true。因为它只考虑记录内部的数据。
        System.out.println(p1.equals(p2)); // Prints true

        Product p3 = new Product("peanut butter", "my-vendor", 100, true);
        record DiscountedProduct(Product product, boolean discounted) {
        }
        System.out.println(new DiscountedProduct(p3, true));

    }

    public record Product(String name, String vendor, int price, boolean inStock) {

        public Product {
            if (price < 0) {
                // throw new IllegalArgumentException();
                price = 100;
            }
        }

    }

    @Test
    public void testInstanceof() {

        Object o = "ddddd";

        // 以前的
        if (o instanceof String) {
            String s = (String)o;
            System.out.println(s.length());
        }

        // 新的方式
        if (o instanceof String s) {
            s.length();
        }

    }

    // Java 16 中还有很多我们无法在本文中介绍的内容，
    // 例如Vector API、Foreign Linker API和Foreign-Memory Access API等孵化器 API 都非常有前途。
    // 并且新版在 JVM 层面也做了很多改进。例如ZGC有一些性能改进；
    // 在 JVM 中做了一些Elastic Metaspace改进；
    // 还有一个新的 Java 应用程序打包工具，允许你为 Windows、

}
