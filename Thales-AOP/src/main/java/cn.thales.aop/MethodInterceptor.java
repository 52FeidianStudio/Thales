package cn.thales.aop;

import cn.thales.aop.invoke.MethodInvocation;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 22:17
 * @Description: null
 */
public interface MethodInterceptor {
    /**
     * 用于调用方法
     * @param methodInvocation
     * @return
     */
    Object invoke(MethodInvocation methodInvocation) throws Throwable;

}
