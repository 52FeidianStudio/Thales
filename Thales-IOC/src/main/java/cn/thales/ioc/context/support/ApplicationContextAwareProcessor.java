package cn.thales.ioc.context.support;

import cn.thales.ioc.beans.factory.BeanFactory;
import cn.thales.ioc.beans.factory.BeanFactoryAware;
import cn.thales.ioc.beans.factory.ConfigurableListableBeanFactory;
import cn.thales.ioc.beans.factory.config.BeanPostProcessor;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 16:59
 * @Description: null
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    ConfigurableListableBeanFactory beanFactory;

    public ApplicationContextAwareProcessor(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return null;
    }
}
