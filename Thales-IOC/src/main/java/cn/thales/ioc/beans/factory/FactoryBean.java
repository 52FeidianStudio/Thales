package cn.thales.ioc.beans.factory;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 22:34
 * @Description: null
 */
public interface FactoryBean<T> {
    /**
     * 直接获取Bean对象
     * @return
     */
    T getObject();

    /**
     * 获取Class对象
     * @return
     */
    Class<?> getObjectType();

    /**
     * 判断是否是单例
     * @return
     */
    boolean isSingleton();

}
