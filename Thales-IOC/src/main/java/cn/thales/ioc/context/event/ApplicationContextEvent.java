package cn.thales.ioc.context.event;

import cn.thales.ioc.context.ApplicationContext;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 11:41
 * @Description: null
 */
public  class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * 获取事件源,此处为ApplicationContext
     * @return
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext)getSource();
    }
}
