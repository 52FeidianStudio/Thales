package cn.thales.config;

import cn.thales.ioc.annotation.Component;
import cn.thales.ioc.beans.factory.FactoryBean;
import cn.thales.mapper.IUserMapper;
import cn.thales.mapper.UserMapper;

import java.lang.reflect.Proxy;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/24 12:15
 * @Description: null
 */
@Component
public class MapperFactoryBean implements FactoryBean<IUserMapper> {
    @Override
    public IUserMapper getObject() {
        return (IUserMapper) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{IUserMapper.class},
                (proxy, method, args) -> {
                    System.out.println("被代理了");
                    return "proxy";
                });
    }

    @Override
    public Class<?> getObjectType() {
        return IUserMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
