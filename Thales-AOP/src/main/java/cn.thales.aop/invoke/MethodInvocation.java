package cn.thales.aop.invoke;

import java.lang.reflect.Method;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/24 23:10
 * @Description: null
 */
public interface MethodInvocation {
    /**
     * 获取方法引用
     * @return
     */
    Method getMethod();

    /**
     * 获取方法的参数
     * @return
     */
    Object[] getArguments();


    /**
     * 调用该方法
     * @return
     * @throws Throwable
     */
    Object proceed() throws Throwable;

}
