package cn.thales.ioc.beans.support;

import cn.thales.ioc.core.io.ClassPathResource;
import cn.thales.ioc.core.io.Resource;
import cn.thales.ioc.core.io.ResourceLoader;
import cn.thales.ioc.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 21:01
 * @Description: null
 */
public class PathMatchingResourcePatternResolver implements ResourcePatternResolver {
    private final ResourceLoader resourceLoader;
    public PathMatchingResourcePatternResolver(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    @Override
    public Resource getResource(String location) {
        return resourceLoader.getResource(location);
    }

    @Override
    public List<? extends Resource> getResources(String location) {
        Set<Class<?>> classes = ClassUtils.getClasses(location);
        List<ClassPathResource> classPathResources = new ArrayList<>();
        for (Class<?> clazz:classes) {
            classPathResources.add(new ClassPathResource("",clazz.getClassLoader(),clazz));
        }
        return classPathResources;
    }
}
