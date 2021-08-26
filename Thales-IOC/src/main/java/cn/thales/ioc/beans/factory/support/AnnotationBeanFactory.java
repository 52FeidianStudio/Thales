package cn.thales.ioc.beans.factory.support;

import cn.thales.ioc.beans.factory.config.BeanDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/18 12:12
 * @Description: null
 */
public class AnnotationBeanFactory extends AbstractBeanFactory implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    List<String> beanDefinitionsName = new ArrayList<>();

    @Override
    public boolean containsBean(String name) {
        return getSingleton(name)!=null;
    }

    @Override
    public Object getBean(String name, Class requiredType) {
        return null;
    }

    @Override
    public String[] getAliases(String name) {
        return new String[0];
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return new String[0];
    }

    @Override
    public String[] getBeanNamesByType(Class<?> type) {
        ArrayList<String> strings = new ArrayList<>();
        for (String name : this.beanDefinitionsName) {
//            Class<?>[] interfaces = getBeanDefinition(name).getBeanClass().getInterfaces();
//            for(Class< ? > inter:interfaces){
//                if(inter==type){
//                    strings.add(name);
//                }
//            }
            if(type.isAssignableFrom(getBeanDefinition(name).getBeanClass())){
                strings.add(name);
            }

        }
        return strings.toArray(new String[0]);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) {
        String[] beanNamesByType = getBeanNamesByType(type);
        HashMap<String, T> map = new HashMap<>(15);
        for (String name : beanNamesByType) {
            map.put(name, (T) getBean(name));
        }
        return map;
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public void preInstantiateSingletons() {
        List<String> beanDefinitionsName = new ArrayList<>(this.beanDefinitionsName);
        for(String beanDefinitionName:beanDefinitionsName){
            getBean(beanDefinitionName);
        }

    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanDefinition.getBeanName(), beanDefinition);
        beanDefinitionsName.add(beanDefinition.getBeanName());
    }
}
