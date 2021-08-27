package cn.thales.ioc.beans.factory.support;

import cn.thales.ioc.beans.factory.config.BeanDefinition;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/16 21:34
 * @Description: 注册BeanDefinition
 */
public interface BeanDefinitionRegistry {
    /**
     * 向BeanFactory注册BeanDefinition
     * @param beanDefinition
     */
    void registerBeanDefinition(BeanDefinition beanDefinition);
}
