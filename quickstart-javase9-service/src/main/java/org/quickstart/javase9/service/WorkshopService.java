/**
 * 项目名称：quickstart-javase9-service 
 * 文件名：WorkshopService.java
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
 * WorkshopService
 * 
 * @author：youngzil@163.com
 * @2018年3月28日 下午1:22:11
 * @since 1.0
 */
public class WorkshopService implements EventService {

    @Override
    public List<String> getEvents() {
        return Stream.of("Kubernetes", "Gamification").map(WorkshopService::prefix).collect(Collectors.toList());
    }

    static String prefix(String input) {
        return "Workshop: " + input;
    }
}
