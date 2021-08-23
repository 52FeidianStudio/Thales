package cn.thales.ioc.beans.factory.config;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/21 22:02
 * @Description: null
 */
public class BeanReference {
    String beanName;
    Class< ? > clazz;

    public String getBeanName() {
        return beanName;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public BeanReference(String beanName, Class<?> clazz) {
        this.beanName = beanName;
        this.clazz = clazz;
    }
}
