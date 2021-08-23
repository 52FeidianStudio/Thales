package cn.thales.ioc.context.event;

import cn.thales.ioc.beans.factory.BeanFactory;
import cn.thales.ioc.context.ApplicationListener;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 17:59
 * @Description:
 * 针对事件广播器的一个简单实现
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    private Executor taskExecutor = Executors.newSingleThreadExecutor();

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener<ApplicationEvent> listener : getApplicationListeners(event)) {
            if (taskExecutor != null) {
                taskExecutor.execute(() -> listener.onApplicationEvent(event));
            }
            else {
                listener.onApplicationEvent(event);
            }
        }

    }

    public SimpleApplicationEventMulticaster() {
    }


    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    public Executor getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }
}
