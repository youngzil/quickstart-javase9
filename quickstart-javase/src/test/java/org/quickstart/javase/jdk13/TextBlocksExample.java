package org.quickstart.javase.jdk13;

public class TextBlocksExample {
    public static void main(String[] args) {
//        String a = """""" 需要换行
        // 需要从新行开始
        String text = """
        fsafs""";

        // text = "fsafs"
        System.out.println(text);

        // 前面空格的处理
        String info = """
        a
        b""";
        // a\nb
        System.out.println(info);

        String info2 = """
        a
        b
        """;
        // "a\nb\n"
        System.out.println(info2);

        String info3 = """
        a
        b
        c
""";
        // "        a\n        b\n        c\n"
        System.out.println(info3);
        String emptyString ="""
        """;
        System.out.println(emptyString);
    }
}
