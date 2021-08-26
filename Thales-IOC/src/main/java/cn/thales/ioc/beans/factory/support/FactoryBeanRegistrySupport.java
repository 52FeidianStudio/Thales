package cn.thales.ioc.beans.factory.support;

import cn.thales.ioc.beans.factory.FactoryBean;
import cn.thales.ioc.beans.support.DefaultSingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/24 10:46
 * @Description: null
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    private  final Map<String,Object> factoryBeanObjectCache = new ConcurrentHashMap<>();
    protected Object getCachedObjectForFactoryBean(String beanName){
        return factoryBeanObjectCache.get(beanName);
    }
    protected Object getObjectFromFactoryBean(FactoryBean factoryBean,String name){
        Object o = factoryBeanObjectCache.get(name);
        if(null==o){
            Object singleton = getSingleton(name);
            factoryBeanObjectCache.put(name,singleton);
            return singleton;
        }
        return o;
    }
}
