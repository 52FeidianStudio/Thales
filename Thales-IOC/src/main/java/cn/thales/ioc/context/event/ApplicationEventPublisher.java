package cn.thales.ioc.context.event;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 12:09
 * @Description:
 * 事件发布者
 */
public interface ApplicationEventPublisher {
    /**
     * 发布事件
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
