package cn.thales.aop.joinpoint;

import java.lang.reflect.Method;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 21:57
 * @Description:
 * 匹配对应的方法
 */
public interface MethodMatcher {
    /**
     * 对应类的对应方法是否匹配
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method,Class< ? > targetClass);
}
