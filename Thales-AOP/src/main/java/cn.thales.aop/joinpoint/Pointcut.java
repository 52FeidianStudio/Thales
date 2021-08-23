package cn.thales.aop.joinpoint;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 20:29
 * @Description: 切点接口,提供获取ClassFilter以及MethodPattern的入口
 */
public interface Pointcut {
    /**
     * 获取ClassFilter
     * @return
     */
    ClassFilter getClassFilter();

    /**
     * 获取MethodMatcher
     * @return
     */
    MethodMatcher getMethodMatcher();
}
