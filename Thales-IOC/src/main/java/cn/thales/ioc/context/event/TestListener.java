package cn.thales.ioc.context.event;

import cn.thales.ioc.context.ApplicationListener;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 18:24
 * @Description: null
 */
public class TestListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("一切都结束了");

    }
}
