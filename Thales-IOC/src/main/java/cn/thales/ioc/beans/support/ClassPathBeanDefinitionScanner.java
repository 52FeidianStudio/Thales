package cn.thales.ioc.beans.support;

import cn.thales.ioc.annotation.Component;
import cn.thales.ioc.beans.factory.config.BeanDefinition;
import cn.thales.ioc.beans.factory.support.AnnotationBeanDefinition;
import cn.thales.ioc.beans.factory.support.BeanDefinitionRegistry;
import cn.thales.ioc.core.io.ClassPathResource;
import cn.thales.ioc.core.io.Resource;
import cn.thales.ioc.core.io.ResourceLoader;
import cn.thales.ioc.utils.BeanUtils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/16 21:41
 * @Description:
 * 用于扫描类路径下的所有资源文件
 */
public class ClassPathBeanDefinitionScanner {
    private ResourcePatternResolver resourcePatternResolver;
    private BeanDefinitionRegistry registry;
    String basePackages;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry,String...basePackage) {
        this.registry = registry;
        this.resourcePatternResolver = new PathMatchingResourcePatternResolver((ResourceLoader) registry);
        this.scan(basePackage);
    }

    public void scan(String...basePackages){
        doScan(basePackages);
    }
    void doScan(String[] basePackages){
        Set<BeanDefinition> beanDefinitions = new LinkedHashSet<>();
        for (String basePackage:basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for(BeanDefinition candidate:candidates){
                beanDefinitions.add(candidate);
                registry.registerBeanDefinition(candidate);
            }
        }

    }

    private Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        List<? extends Resource> resources = getResourcePatternResolver().getResources(basePackage);
        for(Resource resource:resources){
            if(resource instanceof ClassPathResource){
                ClassPathResource classPathResource = (ClassPathResource)resource;
                if(isCandidateComponent(classPathResource.getClazz())){
                    AnnotationBeanDefinition beanDefinition = new AnnotationBeanDefinition();
                    beanDefinition.setClazz(classPathResource.getClazz());
                    beanDefinition.setBeanName(BeanUtils.generateBeanName(classPathResource.getClazz().getName()));
                    candidates.add(beanDefinition);
                }
            }
        }
        return candidates;

    }
    private ResourcePatternResolver getResourcePatternResolver() {
        return this.resourcePatternResolver;
    }
    boolean isCandidateComponent(Class<?> clazz){
        Component declaredAnnotation = clazz.getDeclaredAnnotation(Component.class);
        return declaredAnnotation!=null;
    }

    ;
}
