package cn.thales.ioc.context.config;

import cn.thales.ioc.context.ApplicationContext;
import cn.thales.ioc.context.event.ApplicationEventPublisher;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 17:04
 * @Description: null
 */
public interface ConfigurableApplicationContext extends ApplicationContext, ApplicationEventPublisher,Closeable {
    /**
     *用于进行上下文的配置刷新
     */
    void refresh() throws IOException;
}
