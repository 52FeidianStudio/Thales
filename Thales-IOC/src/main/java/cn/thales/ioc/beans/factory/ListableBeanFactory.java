package cn.thales.ioc.beans.factory;

import java.util.Map;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 16:57
 * @Description:
 * 主要是获取Bean的一些附加信息
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 得到所有BeanDefinition名称
     * @return
     */
    String[] getBeanDefinitionNames();

    /**
     * 根据传入的类型获取对应的bean名称
     * @param type
     * @return
     */
    String[] getBeanNamesByType(Class<?> type);

    /**
     * 获取对应类型的bean,以Map形式返回
     *
     * @param type
     * @param <T>
     * @return
     */
    <T> Map<String, T> getBeansOfType(Class<T> type);
}
