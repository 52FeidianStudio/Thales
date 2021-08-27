package cn.thales.config.aop;

import cn.thales.aop.advice.MethodBeforeAdvice;
import cn.thales.ioc.annotation.Component;
import cn.thales.ioc.annotation.JoinPoint;

import java.lang.reflect.Method;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 16:48
 * @Description: null
 */
@Component
@JoinPoint(classPattern = "",methodPattern = "select.*")
public class MyAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行方法名称--:"+method.getName());
    }
}
