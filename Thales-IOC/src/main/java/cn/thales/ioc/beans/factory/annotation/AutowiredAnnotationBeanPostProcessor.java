package cn.thales.ioc.beans.factory.annotation;

import cn.thales.ioc.annotation.Autowired;
import cn.thales.ioc.annotation.Value;
import cn.thales.ioc.beans.factory.ConfigurableListableBeanFactory;
import cn.thales.ioc.beans.factory.config.BeanReference;
import cn.thales.ioc.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.thales.ioc.beans.support.PropertyValue;
import cn.thales.ioc.utils.BeanUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/21 21:34
 * @Description: null
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    private ConfigurableListableBeanFactory beanFactory;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) {
        return false;
    }

    @Override
    public List<PropertyValue> postProcessProperties(List<PropertyValue> pvs, Object bean, String beanName) {
        Class<?> aClass = bean.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        //处理@Autowired注解
        for(Field field:declaredFields){
            Autowired autowired = field.getDeclaredAnnotation(Autowired.class);
            if(autowired != null){
                pvs.add(new PropertyValue(field.getName(),new BeanReference(BeanUtils.generateBeanName(field.getType().getName()),field.getType())));
            }
        }
        //处理@Value注解
        for(Field field:declaredFields){
            Value value = field.getDeclaredAnnotation(Value.class);
            if(value != null){
                String value1 = value.value();
                pvs.add(new PropertyValue(field.getName(),value1));
            }
        }
        return pvs;
    }
}
