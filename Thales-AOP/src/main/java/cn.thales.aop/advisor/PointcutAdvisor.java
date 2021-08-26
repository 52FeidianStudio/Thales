package cn.thales.aop.advisor;

import cn.thales.aop.joinpoint.Pointcut;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/25 11:10
 * @Description: null
 */
public interface PointcutAdvisor extends Advisor{
    /**
     * 确定在什么地方进行增强
     * @return
     */
    Pointcut getPointcut();
}
