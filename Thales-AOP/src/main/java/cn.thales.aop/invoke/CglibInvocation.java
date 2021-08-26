package cn.thales.aop.invoke;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/25 11:45
 * @Description: null
 */
public class CglibInvocation extends ReflectiveMethodInvocation{
    private final MethodProxy methodProxy;

    public CglibInvocation(Method method, Object[] arguments, Object proxy,MethodProxy methodProxy) {
        super(method, arguments, proxy);
        this.methodProxy = methodProxy;
    }

    @Override
    public Object proceed() throws Throwable {
        return methodProxy.invokeSuper(getProxy(),arguments);
    }
}
