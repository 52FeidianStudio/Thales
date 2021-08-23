package cn.thales.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 20:34
 * @Description:
 * jdk动态代理
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {
    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),null,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy,args);
    }
}
