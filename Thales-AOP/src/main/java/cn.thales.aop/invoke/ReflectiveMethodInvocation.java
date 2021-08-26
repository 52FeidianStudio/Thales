package cn.thales.aop.invoke;

import java.lang.reflect.Method;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/25 11:38
 * @Description: null
 */
public class ReflectiveMethodInvocation implements ProxyMethodInvocation{
    protected Method method;
    protected Object[] arguments;
    protected Object proxy;
    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        return null;
    }

    @Override
    public Object getProxy() {
        return proxy;
    }

    public ReflectiveMethodInvocation(Method method, Object[] arguments,Object proxy) {
        this.method = method;
        this.arguments = arguments;
        this.proxy = proxy;
    }
}
