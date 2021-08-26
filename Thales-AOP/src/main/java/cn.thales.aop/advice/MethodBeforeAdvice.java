package cn.thales.aop.advice;

import java.lang.reflect.Method;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/25 10:57
 * @Description: null
 */
public interface MethodBeforeAdvice extends BeforeAdvice{
    /**
     * 在方法执行之前调用此接口进行功能增强
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
        void before(Method method, Object[] args, Object target) throws Throwable;
}
