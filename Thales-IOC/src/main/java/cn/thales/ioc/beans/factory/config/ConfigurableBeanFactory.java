package cn.thales.ioc.beans.factory.config;

import cn.thales.ioc.beans.factory.BeanFactory;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 20:41
 * @Description:
 * 用于配置Bean,包括BeanPostProcessor
 */
public interface ConfigurableBeanFactory extends BeanFactory, SingletonBeanRegistry {
    /**
     * 添加Bean的后置处理器
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 判断是否是FactoryBean
     * @param beanName
     * @return
     */
    boolean isFactoryBean(String beanName);
}
