package cn.thales.ioc.context;

import cn.thales.ioc.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import cn.thales.ioc.beans.factory.support.AnnotationBeanDefinition;
import cn.thales.ioc.beans.factory.support.AnnotationBeanFactory;
import cn.thales.ioc.beans.factory.BeanFactory;
import cn.thales.ioc.beans.factory.ConfigurableListableBeanFactory;
import cn.thales.ioc.beans.factory.config.BeanDefinition;
import cn.thales.ioc.beans.factory.config.BeanPostProcessor;
import cn.thales.ioc.beans.factory.support.BeanDefinitionRegistry;
import cn.thales.ioc.context.config.ConfigurableApplicationContext;
import cn.thales.ioc.context.event.*;
import cn.thales.ioc.context.support.ApplicationContextAwareProcessor;
import cn.thales.ioc.core.io.Resource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 17:07
 * @Description:
 * 对于ApplicationContext的抽象实现
 * 此类还集成加载Resource功能
 */
public  abstract class AbstractApplicationContext implements ConfigurableApplicationContext, BeanDefinitionRegistry {
    ConfigurableListableBeanFactory beanFactory;
    private ApplicationEventMulticaster applicationEventMulticaster;
    @Override
    public void refresh() throws IOException {

        prepareBeanFactory(beanFactory);
        registerBeanDefinition(new AnnotationBeanDefinition("testListener",TestListener.class));
        //初始化事件广播器
        initApplicationEventMulticaster();

        //向事件广播器注册监听器
        registerListeners();

        //注册beanPostProcessor
        registerBeanPostProcessors(beanFactory);

        //完成剩下的bean的实例化
        finishBeanFactoryInitialization(beanFactory);

        //
        finishRefresh();

    }

    protected  void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory){
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(beanFactory));
    };

    protected  void finishRefresh(){
        publishEvent(new ContextRefreshedEvent(this));
    };

    protected  void registerListeners(){
        Map<String, ApplicationListener> beansOfType = getBeansOfType(ApplicationListener.class);
        beansOfType.values().forEach(listener->applicationEventMulticaster.addApplicationListener(listener));
    };

    protected  void initApplicationEventMulticaster(){
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(getBeanFactory());



    };

    protected  void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory){
        String[] beanNames = beanFactory.getBeanNamesByType(BeanPostProcessor.class);
        beanFactory.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcessor(beanFactory));
        for (String beanName:beanNames) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) getBean(beanName));
        }

    };

    ;
    protected void finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory){
        beanFactory.preInstantiateSingletons();

    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }

    protected Object createBean(){
        return null;
    }
    protected Object doCreateBean(String beanName, BeanDefinition mbd, Object[] args){
        return null;
    }
    protected Object createBeanInstance(String beanName, BeanDefinition mbd, Object[] args){
        return null;
    }

    @Override
    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }

    @Override
    public boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }

    @Override
    public Object getBean(String name, Class requiredType) {
        return beanFactory.getBean(name,requiredType);
    }

    @Override
    public String[] getAliases(String name) {
        return beanFactory.getAliases(name);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return new String[0];
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        if(beanFactory instanceof AnnotationBeanFactory){
            ((AnnotationBeanFactory) beanFactory).registerBeanDefinition(beanDefinition);
        }

    }

    @Override
    public Resource getResource(String location) {
        return null;
    }

    @Override
    public List<? extends Resource> getResources(String location) {
        return null;
    }

    @Override
    public void close() {
        publishEvent(new ContextClosedEvent(this));

    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    protected BeanFactory getBeanFactory(){
        return beanFactory;
    }
    protected void setBeanFactory(ConfigurableListableBeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }
}
