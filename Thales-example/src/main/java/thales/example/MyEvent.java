package thales.example;

import cn.thales.ioc.context.event.ApplicationContextEvent;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 16:06
 * @Description: null
 */
public class MyEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MyEvent(Object source) {
        super(source);
    }
}
