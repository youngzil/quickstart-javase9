/**
 * 项目名称：quickstart-javase9-service 
 * 文件名：TalkService.java
 * 版本信息：
 * 日期：2018年3月28日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.javase9.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.quickstart.javase9.api.EventService;

/**
 * TalkService
 * 
 * @author：youngzil@163.com
 * @2018年3月28日 下午1:11:37
 * @since 1.0
 */
public class TalkService implements EventService {

    public List<String> getEvents() {
        return Stream.of("Deep Learning", "Java 9 Modules in a Nutshell", "Containerized End-2-End-Testing and Monitoring", "JavaScript Lightning Talks", "Citrus & Microservices (Kubernetes)",
                "Apache Cassandra vs. MongoDB").map(TalkService::prefix).collect(Collectors.toList());
    }

    static String prefix(String input) {
        return "Talk: " + input;
    }
}
