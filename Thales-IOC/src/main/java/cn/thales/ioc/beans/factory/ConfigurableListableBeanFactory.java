package cn.thales.ioc.beans.factory;

import cn.thales.ioc.beans.factory.config.BeanDefinition;
import cn.thales.ioc.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/19 21:25
 * @Description: null
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory {
    void preInstantiateSingletons();

    /**
     * 根据名字获取bean定义
     * @param name
     * @return
     */
    BeanDefinition getBeanDefinition(String name);
}
