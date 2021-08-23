package cn.thales.ioc.context.event;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 11:46
 * @Description:
 * 标识上下文关闭事件
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
        System.out.println(source);
    }
}
