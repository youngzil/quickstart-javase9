/**
 * 项目名称：quickstart-javase9-service 
 * 文件名：TalkServiceTest.java
 * 版本信息：
 * 日期：2018年3月28日
 * Copyright yangzl Corporation 2018
 * 版权所有 *
 */
package org.quickstart.javase9.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * TalkServiceTest
 * 
 * @author：youngzil@163.com
 * @2018年3月28日 下午1:13:19
 * @since 1.0
 */
public class TalkServiceTest {

    @Test
    public void testGetEvents() {
        TalkService ts = new TalkService();
        Assert.assertEquals(6, ts.getEvents().size());
    }

    @Test
    public void testPrefix() {
        Assert.assertEquals(TalkService.prefix("blah blah"), "Talk: blah blah");
    }

}
