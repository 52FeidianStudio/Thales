package cn.thales.custom;

import cn.thales.ioc.annotation.Component;
import cn.thales.ioc.beans.factory.config.BeanPostProcessor;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/21 11:41
 * @Description: null
 */
//@Component
public class CustomerBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if(bean instanceof A){
            ((A)bean).setAge(10);
        }

        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return null;
    }
}
