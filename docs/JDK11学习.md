JDK 11 已处于特性冻结状态，看看 Java 11 API 变更提案
https://www.oschina.net/news/98314/java-11-api-changes-so-far


JDK11是一个长期支持版本（LTS，Long-Term-Support），是一个跨跃性版本，等同于java8一样，2018年更新后的jdk8，也即将收费。

1、增强局部变量类型推断var
2、增加一些实用的API
3、移除和废弃的内容
4、HttpClient加强方法
5、Unicode 10 增加了8518个字符, 总计达到了136690个字符. 并且增加了4个脚本.同时还有56个新的emoji表情符号。
6、Remove the JavaEE and CORBA Moudles
      在java11中移除了不太使用的JavaEE模块和CORBA技术，在java11中将java9标记废弃的Java EE及CORBA模块移除掉。
7、JEP : 335 : Deprecate the Nashorn JavaScript Engine
      废除Nashorn javascript引擎，在后续版本准备移除掉，有需要的可以考虑使用GraalVM。

8、JEP : 336 : Deprecate the Pack200 Tools and API
      Java5中带了一个压缩工具:Pack200，这个工具能对普通的jar文件进行高效压缩。其  实现原理是根据Java类特有的结构，合并常数  池，去掉无用信息等来实现对java类的高效压缩。由于是专门对Java类进行压缩的，所以对普通文件的压缩和普通压缩软件没有什么两样，但是对于Jar  文件却能轻易达到10-40%的压缩率。这在Java应用部署中很有用，尤其对于移动Java计算，能够大大减小代码下载量。
9、新的Epsilon垃圾收集器
      A NoOp Garbage Collector JDK上对这个特性的描述是: 开发一个处理内存分配但不实现任何实际内存回收机制的GC, 一旦可用堆内存用完, JVM就会退出.
10、ZGC, 这应该是JDK11最为瞩目的特性, 没有之一. 但是后面带了Experimental, 说明这还不建议用到生产环境。
11、完全支持Linux容器（包括Docker）
12、支持G1上的并行完全垃圾收集



参考
https://my.oschina.net/mdxlcj/blog/3010342





