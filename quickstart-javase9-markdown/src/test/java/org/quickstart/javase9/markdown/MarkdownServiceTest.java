/**
 * 项目名称：quickstart-javase9-markdown 文件名：MarkdownServiceTest.java 版本信息： 日期：2018年3月28日 Copyright yangzl Corporation 2018 版权所有 *
 */
package org.quickstart.javase9.markdown;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * MarkdownServiceTest
 *
 * @author：youngzil@163.com
 * @2018年3月28日 下午1:41:07
 * @since 1.0
 */
public class MarkdownServiceTest {

  @Test
  public void formatList() {
    MarkdownService service = new MarkdownService();
    List<String> abc = List.of("a", "b", "c");

    // assertThat(service.formatList(abc)).isEqualTo("* a\n");
    Assert.assertEquals("* a\n* b\n* c", service.formatList(abc));
  }
}
