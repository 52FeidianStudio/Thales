package cn.thales.ioc.beans.factory.config;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 20:50
 * @Description: null
 */
public interface BeanPostProcessor {
    /**
     * 在初始化之前进行处理
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);

    /**
     * 在初始化之后进行处理
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessAfterInitialization(Object bean, String beanName) ;
}
