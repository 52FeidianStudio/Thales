package cn.thales.ioc.context.event;

import java.util.EventObject;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 11:42
 * @Description: null
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
