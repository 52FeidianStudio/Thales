package cn.thales.ioc.context;

import cn.thales.ioc.context.event.ApplicationContextEvent;
import cn.thales.ioc.context.event.ApplicationEvent;

import java.util.EventListener;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 12:00
 * @Description: 自定义监听器接口
 */
public interface ApplicationListener <E extends ApplicationEvent> extends EventListener {
    /**
     * 监听特定事件
     * @param event
     */
    void onApplicationEvent(E event);
}
