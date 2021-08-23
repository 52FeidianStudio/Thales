package cn.thales.ioc.context.event;

import cn.thales.ioc.context.ApplicationListener;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 11:49
 * @Description:
 * 事件广播器
 */
public interface ApplicationEventMulticaster {
    /**
     * 添加广播事件
     * @param event
     */
    void multicastEvent(ApplicationEvent event);

    /**
     * 添加对于某个事件的监听器
     * @param listener
     */
    void addApplicationListener(ApplicationListener listener);

    /**
     * 移除指定监听器
     * @param listener
     */
    void removeApplicationListener(ApplicationListener listener);


}
