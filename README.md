项目地址
https://github.com/youngzil/quickstart-javase9



- [JDK9和JDK10](docs/JDK9和JDK10.md)
    - [JDK9新特性](#JDK9新特性)
    - [JDK10新特性详解](#JDK10新特性详解)
- [JDK11学习](docs/JDK11学习.md)
    - [JDK11特性](#JDK11特性)
- [JDK12和JDK13](docs/JDK12和JDK13.md)
    - [JDK12新特性详解](#JDK12新特性详解)
    - [JDK13：5大新特性](#JDK13：5大新特性)
- [JDK总的学习](docs/JDK总的学习.md)




关键字：
requires、exports、opens、uses、provides XXX with XXX、等

requires java.sql;
requires java.xml.ws.annotation;

exports org.quickstart.javase9.api;
exports org.quickstart.javase9.api.controller;

opens org.quickstart.javase9.api;
opens org.quickstart.javase9.api.controller;

provides org.quickstart.javase9.api.EventService with org.quickstart.javase9.service.TalkService;

uses org.quickstart.javase9.api.EventService;





