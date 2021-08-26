package cn.thales.aop;

import cn.thales.aop.advice.BeforeAdvice;
import cn.thales.aop.advice.MethodBeforeAdvice;
import cn.thales.aop.invoke.MethodInvocation;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/25 11:13
 * @Description: null
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor, BeforeAdvice {
    MethodBeforeAdvice advice;

    public void setAdvice(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    /**
     * 在真正方法执行之前执行Advice的Before方法,然后再执行真正的方法
     * @param methodInvocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        advice.before(methodInvocation.getMethod(), methodInvocation.getArguments(),methodInvocation);
        return methodInvocation.proceed();
    }
}
