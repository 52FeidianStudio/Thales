package cn.thales.ioc.beans.factory.config;

import cn.thales.ioc.beans.support.PropertyValue;

import java.util.List;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/21 21:28
 * @Description: null
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    /**
     * 在bean实例化之前做处理
     * @param beanClass
     * @param beanName
     * @return
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws IllegalAccessException;

    /**
     * 在bean实例化之后做处理
     * @param bean
     * @param beanName
     * @return
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName);

    /**
     * 对已经给定的属性值再进行处理
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     */
    List<PropertyValue> postProcessProperties(List<PropertyValue> pvs, Object bean, String beanName);
}
