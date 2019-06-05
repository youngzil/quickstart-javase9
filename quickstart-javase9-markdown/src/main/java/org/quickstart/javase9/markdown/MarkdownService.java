/**
 * 项目名称：quickstart-javase9-markdown 
 * 文件名：MarkdownService.java
 * 版本信息：
 * 日期：2018年3月28日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.javase9.markdown;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.quickstart.javase9.api.EventService;

/**
 * MarkdownService
 * 
 * @author：youngzil@163.com
 * @2018年3月28日 下午1:37:40
 * @since 1.0
 */

public class MarkdownService {

    private static List<EventService> eventServices = new ArrayList<>();

    public String formatList(List<String> events) {
        return events.stream().map((e) -> "* " + e).collect(Collectors.joining("\n"));
    }
}
