package cn.thales.ioc.beans.factory;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 11:52
 * @Description:
 */
public interface BeanFactoryAware extends Aware {
    /**
     * 设置对应的BeanFactory属性
     * @param factory
     */
    void setBeanFactory(BeanFactory factory);
}
