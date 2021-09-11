package org.quickstart.javase.jdk11;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/**
 * @author youngzil@163.com
 * @description TODO
 * @createTime 2019/11/4 10:44
 */
public class JDK11NewFeaturesTest {

    @Test
    public void testVar() {
        // 增强局部变量类型推断var
        Consumer<String> consumer = t -> System.out.println(t.toUpperCase());
        Consumer<String> consumer2 = (var t) -> System.out.println(t.toUpperCase());

        // 错误的形式：必须要有类型，可以加上var
        // Consumer<String> consumer3 = (@Deprecated t) -> System.out.println(t.toUpperCase());
        // 正确的形式
        Consumer<String> consumer4 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }

    // 增加一些实用的API
    // 自JDK9和JDK10都为java增加了许多的API，如今JDK11又增加了许多字符串自带方法，如下
    @Test
    public void contextLoads() {
        String str = "woshidage";
        boolean isblank = str.isBlank();  //判断字符串是空白
        boolean isempty = str.isEmpty();  //判断字符串是否为空
        String result1 = str.strip();    //首部和尾位空白
        String result2 = str.stripTrailing();  //去除尾部空白
        String result3 = str.stripLeading();  //去除首部空白
        String copyStr = str.repeat(2);  //复制几遍字符串
        long lineCount = str.lines().count();  //行数统计

        System.out.println(isblank);
        System.out.println(isempty);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(copyStr);
        System.out.println(lineCount);

        // 判断字符串是否为空白
        " ".isBlank();                // true

        // 去除首尾空格
        " Javastack ".strip();          // "Javastack"

        // 去除尾部空格
        " Javastack ".stripTrailing();  // " Javastack"

        // 去除首部空格
        " Javastack ".stripLeading();   // "Javastack "

        // 复制字符串,复制次数
        "Java".repeat(3);             // "JavaJavaJava"

        // 行数统计
        "A\nB\nC".lines().count();    // 3

        // 小于0：java.lang.IllegalArgumentException
        // System.out.println(str.repeat(-2));

        // 等于0：空白串（""）
        System.out.println(str.repeat(0));

        // JavaJavaJava
        System.out.println(str.repeat(3));

        // java.lang.OutOfMemoryError
        System.out.println(str.repeat(Integer.MAX_VALUE));

    }

    // 4.2 HttpClient调用该接口

    @Test
    public void testHTTPClientAPI() throws IOException, InterruptedException {

        // 来看一下 HTTP Client 的用法：

        var request = HttpRequest.newBuilder()//
            .uri(URI.create("https://javastack.cn"))//
            .GET()//
            .build();
        var client = HttpClient.newHttpClient();

        // 同步
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        // 异步
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())//
            .thenApply(HttpResponse::body)//
            .thenAccept(System.out::println);
        // 上面的 .GET() 可以省略，默认请求方式为 Get！

    }

    //同步调用
    @Test
    public void testHttpClient() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("")).build();
        BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response = client.send(request, handler);
        String body = response.body();
        System.out.println(body);

    }

    //异步调用
    @Test
    public void testHttpClient2() throws IOException, InterruptedException, ExecutionException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("")).build();
        BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request, handler);
        HttpResponse<String> result = response.get();
        String body = result.body();
        System.out.println(body);
    }

    @Test
    public void test3() {

        // Pack200被Deprecate
        // 压缩
        // Packer packer = Pack200.newPacker();
        // OutputStream output = new BufferedOutputStream(new FileOutputStream(outfile));
        // packer.pack(new JarFile(jarFile), output);
        // output.close();

        // 解压
        // Unpacker unpacker = Pack200.newUnpacker();
        // output = new JarOutputStream(new FileOutputStream(jarFile));
        // unpacker.unpack(pack200File, output);
        // output.close();
    }

    @Test
    public void testInputStream() throws IOException {

        // InputStream 终于有了一个非常有用的方法：transferTo，可以用来将数据直接传输到 OutputStream，这是在处理原始数据流时非常常见的一种用法，如下示例。

        var classLoader = ClassLoader.getSystemClassLoader();
        var inputStream = classLoader.getResourceAsStream("javastack.txt");
        var javastack = File.createTempFile("javastack2", "txt");
        try (var outputStream = new FileOutputStream(javastack)) {
            inputStream.transferTo(outputStream);
        }

    }

}
