package cn.thales.ioc.beans.factory.config;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 20:50
 * @Description: null
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName);
    Object postProcessAfterInitialization(Object bean, String beanName) ;
}
