package cn.thales.ioc.beans.factory.support;

import cn.thales.ioc.core.io.Resource;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/16 21:37
 * @Description:
 * 用于从Resource指定的资源文件中获取到BeanDefinition
 */
public interface BeanDefinitionReader {
    /**
     * 获取注册组件
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 根据传入的Resource解析出BeanDefinition
     * @param resource
     * @return
     */
    int loadBeanDefinition(Resource resource);

    /**
     * 解析多个resource文件
     * @param resource
     * @return
     */
    int loadBeanDefinition(Resource... resource);

    /**
     * 根据位置加载BeanDefinition
     * @param location
     * @return
     */
    int loadBeanDefinition(String location);


}
