项目地址
https://github.com/youngzil/quickstart-javase9


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





