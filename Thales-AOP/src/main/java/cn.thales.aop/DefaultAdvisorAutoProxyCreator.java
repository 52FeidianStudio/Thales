package cn.thales.aop;

import cn.thales.aop.advice.Advice;
import cn.thales.aop.advice.AdvisedSupport;
import cn.thales.aop.advice.BeforeAdvice;
import cn.thales.aop.advice.MethodBeforeAdvice;
import cn.thales.aop.advisor.Advisor;
import cn.thales.aop.advisor.PointcutAdvisor;
import cn.thales.aop.advisor.RegexMethodPointcutAdvisor;
import cn.thales.aop.joinpoint.ClassFilter;
import cn.thales.aop.joinpoint.Pointcut;
import cn.thales.ioc.annotation.Component;
import cn.thales.ioc.annotation.JoinPoint;
import cn.thales.ioc.beans.factory.BeanFactory;
import cn.thales.ioc.beans.factory.BeanFactoryAware;
import cn.thales.ioc.beans.factory.ConfigurableListableBeanFactory;
import cn.thales.ioc.beans.factory.config.ConfigurableBeanFactory;
import cn.thales.ioc.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.thales.ioc.beans.factory.support.AnnotationBeanDefinition;
import cn.thales.ioc.beans.factory.support.AnnotationBeanFactory;
import cn.thales.ioc.beans.support.PropertyValue;
import cn.thales.ioc.utils.BeanUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 10:54
 * @Description: null
 */
@Component
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    AnnotationBeanFactory beanFactory;

    public void setBeanFactory(AnnotationBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)  {
        Map<String, MethodBeforeAdvice> beansOfType = new HashMap<>();
        if(MethodBeforeAdvice.class.isAssignableFrom(beanClass)){
            JoinPoint joinPoint = beanClass.getDeclaredAnnotation(JoinPoint.class);
            if(joinPoint != null){
                String classPattern = joinPoint.classPattern();
                String methodPattern = joinPoint.methodPattern();
                RegexMethodPointcutAdvisor advisor = new RegexMethodPointcutAdvisor();
                advisor.setPattern(methodPattern);
                try {
                    advisor.setAdvice((Advice) beanClass.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                AnnotationBeanDefinition beanDefinition = new AnnotationBeanDefinition();
                beanDefinition.setBeanName(BeanUtils.generateBeanName(beanClass.getName()));
                beanDefinition.setClazz(advisor.getClass());
                beanFactory.registerBeanDefinition(beanDefinition);
                beanFactory.registerSingleton(beanDefinition.getBeanName(),advisor);
            }
       }else{
            Collection<PointcutAdvisor> advisors = beanFactory.getBeansOfType(PointcutAdvisor.class).values();
            for (PointcutAdvisor pointcutAdvisor: advisors) {
                ClassFilter classFilter = pointcutAdvisor.getPointcut().getClassFilter();
                if(classFilter != null&&!classFilter.matches(beanClass)){
                    continue;
                }
                AdvisedSupport advisedSupport = new AdvisedSupport();
                SimpleBeanTargetSource targetSource = new SimpleBeanTargetSource();
                targetSource.setTargetClass(beanClass);
                advisedSupport.setTargetSource(targetSource);
                advisedSupport.addAdvisor(pointcutAdvisor);
                return new ProxyFactory(advisedSupport).getProxy();


            }
        }

        return null;
    }
    Advisor getAdvisor(){
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) {
        return false;
    }

    @Override
    public List<PropertyValue> postProcessProperties(List<PropertyValue> pvs, Object bean, String beanName) {
        return null;
    }

    @Override
    public void setBeanFactory(BeanFactory factory) {
        setBeanFactory((AnnotationBeanFactory) factory);
    }
}
