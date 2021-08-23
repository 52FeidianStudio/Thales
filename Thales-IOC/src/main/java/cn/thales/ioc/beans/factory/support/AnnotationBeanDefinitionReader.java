package cn.thales.ioc.beans.factory.support;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/16 21:38
 * @Description: null
 */
public class AnnotationBeanDefinitionReader {
    private BeanDefinitionRegistry registry;
    public AnnotationBeanDefinitionReader(BeanDefinitionRegistry registry){
        this.registry = registry;
    }
}
