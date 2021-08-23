package cn.thales.ioc.beans.factory.support;

import cn.thales.ioc.beans.factory.BeanFactory;
import cn.thales.ioc.beans.factory.config.BeanDefinition;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/18 17:54
 * @Description:
 * 采用策略模式,实例化类需要继承此接口
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, BeanFactory owner);
}
