package cn.thales.ioc.beans.factory.support;

import cn.thales.ioc.beans.factory.BeanFactoryAware;
import cn.thales.ioc.beans.factory.ConfigurableListableBeanFactory;
import cn.thales.ioc.beans.factory.FactoryBean;
import cn.thales.ioc.beans.factory.config.BeanDefinition;
import cn.thales.ioc.beans.factory.config.BeanPostProcessor;
import cn.thales.ioc.beans.factory.config.BeanReference;
import cn.thales.ioc.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.thales.ioc.beans.support.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 20:42
 * @Description: null
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableListableBeanFactory {
    List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
    private InstantiationStrategy instantiationStrategy;

    @Override
    public boolean isFactoryBean(String beanName) {
        Object beanInstance = getSingleton(beanName);
        //如果有实例化对象,根据对象来判断
        if (beanInstance != null) {
            return (beanInstance instanceof FactoryBean);
        }
        //没有则根据BeanDefinition判断
        return getBeanDefinition(beanName).isFactoryBean();
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }

    public void addBeanPostProcessors(Collection<? extends BeanPostProcessor> beanPostProcessors) {
        this.beanPostProcessors=new ArrayList<>(beanPostProcessors);
    }
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[]args){
        Object beanInstance = null;
        try {
            //实例化
            beanInstance = createBeanInstance(beanName,beanDefinition,args);

            //填充属性
            populateBean(beanName,beanDefinition,beanInstance);

            //初始化
            initializeBean(beanName,beanInstance,beanDefinition);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return beanInstance;

    };
    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition,Object[]args) throws IllegalAccessException {
        Object beanInstance=null;
        //实例化对象
        if(beanDefinition.isInterfaceTag()||beanDefinition.isAbstractTag()){
            return null;
        }
        for (BeanPostProcessor beanPostProcessor:getBeanPostProcessors()) {
            if(beanPostProcessor instanceof InstantiationAwareBeanPostProcessor){
                InstantiationAwareBeanPostProcessor instantiationAwareBeanPostProcessor = (InstantiationAwareBeanPostProcessor) beanPostProcessor;
               beanInstance = instantiationAwareBeanPostProcessor.postProcessBeforeInstantiation(beanDefinition.getBeanClass(),beanName);
            }
        }
        if(null==beanInstance){
//            return beanInstance;
            beanInstance = getInstantiationStrategy().instantiate(beanDefinition,beanName,this);
        }
        addEarlySingletonObject(beanName,beanInstance);



        return beanInstance;

    };
    protected void populateBean(String beanName, BeanDefinition mbd, Object bean) throws IllegalAccessException {

        //在注入属性之前进一步进行特性化修改
        List<PropertyValue> propertiesValues = mbd.getPropertiesValues();
        if (propertiesValues==null) {
            propertiesValues = new ArrayList<>();
        }
        for (BeanPostProcessor beanPostProcessor: getBeanPostProcessors()) {
            if(beanPostProcessor instanceof InstantiationAwareBeanPostProcessor){
                InstantiationAwareBeanPostProcessor instantiationAwareBeanPostProcessor = (InstantiationAwareBeanPostProcessor) beanPostProcessor;
                instantiationAwareBeanPostProcessor.postProcessProperties(propertiesValues, bean,beanName);
            }
        }
        for (PropertyValue propertiesValue:propertiesValues){
            Object oldValue = propertiesValue.getValue();
            Object newValue = oldValue;
            if(oldValue instanceof BeanReference){
                BeanReference beanReference = (BeanReference) oldValue;
                String[] beanNamesByType = new String[0];
                //此处可以根据配置文件来指定接口实现类型,默认是第一个实现类
                beanNamesByType = getBeanNamesByType(beanReference.getClazz());
                if(beanNamesByType.length > 0){
                    newValue = getBean(beanNamesByType[0]);
                }else {
                    newValue = null;
                }
                //如果容器自身的BeanFactory无法找到,则由外部提供的BeanFactory加载
                if(newValue==null){
                    Map<String, FactoryBean> beansOfType = getBeansOfType(FactoryBean.class);
                    Collection<FactoryBean> values = beansOfType.values();
                    for (FactoryBean value: values) {
                        if(beanReference.getClazz()==value.getObjectType()){
                            newValue = value.getObject();
                            break;
                        }
                    }

                }
            }

            //注入属性
            for(Field field:mbd.getBeanClass().getDeclaredFields()){
                field.setAccessible(true);
                if (field.getName().equals(propertiesValue.getName())&&field.getType().isAssignableFrom(newValue.getClass())) {
                    field.set(bean,newValue);
                }
            }

        }
    }
    protected Object initializeBean(String beanName, Object bean, BeanDefinition mbd){
        //注入容器相关属性
        invokeAwareMethods(beanName, bean);
        applyBeanPostProcessorsBeforeInitialization(bean,beanName);
        applyBeanPostProcessorsAfterInitialization(bean,beanName);
        return  bean;

    }

    protected  void invokeAwareMethods(String beanName, Object bean){
        if(bean instanceof BeanFactoryAware){
            ((BeanFactoryAware)bean).setBeanFactory(this);
        }
    };

    /**
     * 初始化方法之前执行
     * @param existingBean
     * @param beanName
     * @return
     */
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName){
        Object result = existingBean;

        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;

    }

    /**
     * 初始化方法之后执行
     * @param existingBean
     * @param beanName
     * @return
     */
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName){
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object getBean(String name) {
        return doGetBean(name);
    }
    protected Object doGetBean(String name){
        //查找是否为已经注册的实例
        Object singleton = getSingleton(name);
        Object beanInstance;
        if(singleton!=null){
            beanInstance = getObjectForBeanInstance(singleton,name,name);
            return beanInstance;
        }

        //重新创建bean
        singleton = createBean(name, getBeanDefinition(name), null);

        //注册
        registerSingleton(name,singleton);
        beanInstance = getObjectForBeanInstance(singleton,name,name);
        return beanInstance;
    }
    protected Object getObjectForBeanInstance(Object beanInstance, String name,String beanName){
        //不是FactoryBean直接返回
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        //是FactoryBean则从FactoryBean中获取对应bean
        Object object = null;
        object = getObjectFromFactoryBean((FactoryBean) beanInstance, beanName);
        return object;

    }
    @Override
    public Object getSingleton(String beanName) {
        Object singleton = super.getSingleton(beanName);
//        Object bean = createBean(beanName, getBeanDefinition(beanName), null);
//        if(bean != null){
//            registerSingleton(beanName,bean);
//        }

        return singleton;

    }

    /**
     * 根据beanName获取对应的bean定义信息
     * @param beanName
     * @return
     */
    @Override
    public abstract BeanDefinition getBeanDefinition(String beanName);
    protected InstantiationStrategy getInstantiationStrategy() {
        if(this.instantiationStrategy==null){
            instantiationStrategy = new SimpleInstantiationStrategy();
        }
        return this.instantiationStrategy;
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }
}
