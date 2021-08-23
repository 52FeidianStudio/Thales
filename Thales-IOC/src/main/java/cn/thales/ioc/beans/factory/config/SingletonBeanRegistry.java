package cn.thales.ioc.beans.factory.config;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/19 10:57
 * @Description: 增加Bean注册功能
 */
public interface SingletonBeanRegistry {
    /**
     * 注册完整bean实例
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * 根据名字获取bean实例
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

}
