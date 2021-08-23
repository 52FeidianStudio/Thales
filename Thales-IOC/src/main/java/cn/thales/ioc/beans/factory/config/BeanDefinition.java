package cn.thales.ioc.beans.factory.config;

import cn.thales.ioc.beans.support.PropertyValue;

import java.util.List;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/16 21:19
 * @Description: null
 */
public interface BeanDefinition {
    /**
     * 得到该bean的名字
     * @return
     */
    String getBeanName();

    /**
     * 得到该bean的Class对象
     * @param <T>
     * @return
     */
    <T> Class<T> getBeanClass();

    /**
     * 该bean是否是单例
     * @return
     */
    boolean isSingleton();
    /**
     * 获取该bean的别名
     */

    String[] getAliases();

    /**
     * 获取该bean的各个属性
     * @return
     */
    List<PropertyValue> getPropertiesValues();

    /**
     * 判断是否为抽象类
     * @return
     */
    public boolean isAbstractTag() ;

    /**
     * 判断是否为接口
     * @return
     */
    public boolean isInterfaceTag() ;
}
