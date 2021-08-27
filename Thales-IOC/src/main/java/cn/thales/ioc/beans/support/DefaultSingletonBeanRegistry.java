package cn.thales.ioc.beans.support;

import cn.thales.ioc.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/19 11:04
 * @Description: null
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);
    private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>(16);

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.putIfAbsent(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);

    }

    @Override
    public Object getSingleton(String beanName) {
        Object o = singletonObjects.get(beanName);
        if (null == o) {
            o = earlySingletonObjects.get(beanName);
        }
        return o;
    }
    public void addEarlySingletonObject(String beanName, Object singletonObject){
        earlySingletonObjects.put(beanName,singletonObject);
    }
}
