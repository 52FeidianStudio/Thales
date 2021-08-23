package cn.thales.ioc.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.thales.ioc.beans.factory.ConfigurableListableBeanFactory;
import cn.thales.ioc.beans.factory.config.BeanDefinition;
import cn.thales.ioc.beans.factory.config.BeanPostProcessor;
import cn.thales.ioc.beans.factory.config.BeanReference;
import cn.thales.ioc.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.thales.ioc.beans.support.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 20:42
 * @Description: null
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableListableBeanFactory {
    List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
    private InstantiationStrategy instantiationStrategy;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.add(beanPostProcessor);
    }

    public void addBeanPostProcessors(Collection<? extends BeanPostProcessor> beanPostProcessors) {
        this.beanPostProcessors=new ArrayList<>(beanPostProcessors);
    }
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[]args){
        Object beanInstance = createBeanInstance(beanName,beanDefinition,args);
        return beanInstance;

    };
    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition,Object[]args){
        Object beanInstance;
        //实例化对象
        if(beanDefinition.isInterfaceTag()||beanDefinition.isAbstractTag()){
            return null;
        }
        beanInstance = getInstantiationStrategy().instantiate(beanDefinition,beanName,this);

        //填充属性
        populateBean(beanName,beanDefinition,beanInstance);

        initializeBean(beanName,beanInstance,beanDefinition);
        return beanInstance;

    };
    protected void populateBean(String beanName, BeanDefinition mbd, Object bean){
//        Field[] fields = bean.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            field.setAccessible(true);
//            //自定义类型注入
//            if(field.getAnnotation(Autowired.class)!=null) {
//                Autowired annotation = field.getAnnotation(Autowired.class);
////                String value = annotation.value();
//                try {
//                if (containsBean(field.getName())) {
//                        field.set(bean,getSingleton(field.getName()));
//
//                } else {
//                    getSingleton(field.getName());
//
//                    field.set(bean, getSingleton(field.getName()));
//                }
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//            }
//        }
//        }

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
                newValue = getBean(beanReference.getBeanName());
            }
            BeanUtil.setFieldValue(bean,propertiesValue.getName(), newValue);

        }
    }
    protected Object initializeBean(String beanName, Object bean, BeanDefinition mbd){
        applyBeanPostProcessorsBeforeInitialization(bean,beanName);
        applyBeanPostProcessorsAfterInitialization(bean,beanName);
        return  bean;

    }

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
    public Object getSingleton(String beanName) {
        Object singleton = super.getSingleton(beanName);
        if(singleton != null){
            return singleton;
        }
        Object bean = createBean(beanName, getBeanDefinition(beanName), null);
        registerSingleton(beanName,bean);
        return bean;

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
