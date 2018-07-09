/**
 * 项目名称：quickstart-javase9-service 
 * 文件名：WorkshopServiceTest.java
 * 版本信息：
 * 日期：2018年3月28日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.javase9.service;

/**
 * WorkshopServiceTest 
 *  
 * @author：yangzl@asiainfo.com
 * @2018年3月28日 下午1:23:02 
 * @since 1.0
 */
import org.junit.Assert;
import org.junit.Test;

public class WorkshopServiceTest {

    @Test
    public void testGetEvents() {
        WorkshopService ts = new WorkshopService();
        Assert.assertEquals(2, ts.getEvents().size());
    }

    @Test
    public void testPrefix() {
        Assert.assertEquals(WorkshopService.prefix("blah blah"), "Workshop: blah blah");
    }

}
