package cn.thales.aop;

import cn.thales.aop.advice.AdvisedSupport;
import cn.thales.aop.advisor.PointcutAdvisor;
import cn.thales.aop.invoke.CglibInvocation;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/25 11:28
 * @Description: null
 */
public class CglibAopProxy implements AopProxy{
    private final AdvisedSupport advised;

    public CglibAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(advised.getTargetSource().getTargetClass());
        enhancer.setCallback(new DynamicAdvisedInterceptor(advised));
        return enhancer.create();
    }
    private static class DynamicAdvisedInterceptor implements MethodInterceptor {

        private final AdvisedSupport advised;

        public DynamicAdvisedInterceptor(AdvisedSupport advised) {
            this.advised = advised;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            CglibInvocation cglibInvocation = new CglibInvocation(method,objects,o,methodProxy);
            //根据匹配结果判定是否调用增强方法
            for(PointcutAdvisor advisor: advised.getAdvisor()){
                if(advisor.getPointcut().getMethodMatcher().matches(method,advised.getTargetSource().getTargetClass())){
                    return advised.getMethodInterceptor().get(0).invoke(cglibInvocation);
                }
            }

            //调用源方法
            return cglibInvocation.proceed();
        }
    }
}
