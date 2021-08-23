package cn.thales.ioc.beans.factory;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/16 21:29
 * @Description:
 * 主要作用是获取Bean的实例
 */
public interface BeanFactory {
    /**
     * 根据名字获取Bean实例
     * @param name
     * @return
     */
    Object getBean(String name);

    /**
     * 根据名字判断有没有该Bean
     * @param name
     * @return
     */
    boolean containsBean(String name);

    /**
     * 得到指定类型的bean
     * @param name
     * @param requiredType
     * @return
     */
    Object getBean(String name, Class requiredType);

    /**
     * 得到bean的别名
     * @param name
     * @return
     */
    String[] getAliases(String name);
}
