package cn.thales.ioc.context;

import cn.thales.ioc.beans.factory.support.AnnotationBeanFactory;
import cn.thales.ioc.beans.factory.support.AnnotationBeanDefinitionReader;
import cn.thales.ioc.beans.support.ClassPathBeanDefinitionScanner;

import java.io.IOException;
import java.util.Map;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 17:16
 * @Description: null
 */
public class AnnotationConfigApplicationContext extends AbstractApplicationContext {
    private AnnotationBeanDefinitionReader reader;
    private ClassPathBeanDefinitionScanner scanner;
    public AnnotationConfigApplicationContext(String...basePackage) throws IOException, ClassNotFoundException {
        assert basePackage!=null;
        setBeanFactory(new AnnotationBeanFactory());
        scanner = new ClassPathBeanDefinitionScanner(this,basePackage);
        reader = new AnnotationBeanDefinitionReader(this);
        refresh();
//        Class.forName("cn.thales.aop.DefaultAdvisorAutoProxyCreator");

    }
    public void scan(String...basePackage){
        scanner.scan();

    }

    @Override
    public String[] getBeanNamesByType(Class<?> type) {
        return beanFactory.getBeanNamesByType(type);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) {
        return beanFactory.getBeansOfType(type);
    }
}
