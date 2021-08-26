package cn.thales.aop.joinpoint;

import java.lang.reflect.Method;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 10:32
 * @Description: null
 */
public class JdkRegexMethodPointcut implements MethodMatcher, Pointcut{
    @Override
    public ClassFilter getClassFilter() {
        return null;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return true;
    }
}
