package cn.thales.ioc.context.event;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 11:47
 * @Description:
 * 标识上下文刷新事件
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
