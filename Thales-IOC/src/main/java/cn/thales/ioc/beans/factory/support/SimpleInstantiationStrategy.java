package cn.thales.ioc.beans.factory.support;

import cn.thales.ioc.beans.factory.BeanFactory;
import cn.thales.ioc.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/19 21:40
 * @Description: null
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, BeanFactory owner) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        try {

            if (beanClass.isInterface()|| Modifier.isAbstract(beanClass.getModifiers())) {
                return null;
            }
            return constructors[0].newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
