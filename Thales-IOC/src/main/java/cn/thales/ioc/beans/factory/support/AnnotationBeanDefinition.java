package cn.thales.ioc.beans.factory.support;

import cn.thales.ioc.beans.factory.config.BeanDefinition;
import cn.thales.ioc.beans.support.PropertyValue;

import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/18 16:09
 * @Description: 专门用于存储以注解形式定义的bean的信息
 */
public class AnnotationBeanDefinition implements BeanDefinition {
    private String beanName;
    private Class clazz;
    private boolean singleton;
    private String[] aliases;
    private List<PropertyValue> propertiesValues;
    private boolean abstractTag;
    private boolean interfaceTag;
    private boolean factoryBean;

    public AnnotationBeanDefinition(String beanName, Class clazz) {
        this.beanName = beanName;
        this.clazz = clazz;
    }

    public AnnotationBeanDefinition() {
    }

    @Override
    public String getBeanName() {
        return beanName;
    }

    @Override
    public <T> Class<T> getBeanClass() {
        return (Class<T>) clazz;
    }

    @Override
    public boolean isSingleton() {
        return singleton;
    }

    @Override
    public String[] getAliases() {
        return aliases;
    }

    @Override
    public List<PropertyValue> getPropertiesValues() {
        return propertiesValues;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
        abstractTag = Modifier.isAbstract(clazz.getModifiers());
        interfaceTag = clazz.isInterface();
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }

    public Class getClazz() {
        return clazz;
    }

    @Override
    public boolean isAbstractTag() {
        return abstractTag;
    }

    @Override
    public boolean isInterfaceTag() {
        return interfaceTag;
    }

    @Override
    public boolean isFactoryBean() {
        return factoryBean;
    }

    public void setFactoryBean(boolean factoryBean) {
        this.factoryBean = factoryBean;
    }

    public void setAliases(String[] aliases) {
        this.aliases = aliases;
    }

    public void setPropertiesValues(List<PropertyValue> propertiesValues) {
        this.propertiesValues = propertiesValues;
    }
}
