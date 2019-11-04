/**
 * 项目名称：quickstart-javase9-markdown 
 * 文件名：Devday.java
 * 版本信息：
 * 日期：2018年3月28日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.javase9.markdown;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import org.quickstart.javase9.api.EventService;

/**
 * Devday
 * 
 * @author：youngzil@163.com
 * @2018年3月28日 下午1:37:23
 * @since 1.0
 */

public class Devday {

    private static List<EventService> eventServices = new ArrayList<>();
    private static MarkdownService markdownService = new MarkdownService();

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("ConSol Devday Schedule");
        System.out.println("======================");

        ServiceLoader.load(EventService.class).forEach(eventServices::add);

        List<String> events = new ArrayList<>();

      System.out.println(eventServices);
        eventServices.stream().map(EventService::getEvents).forEach(events::addAll);

        System.out.println(markdownService.formatList(events));
    }
}
