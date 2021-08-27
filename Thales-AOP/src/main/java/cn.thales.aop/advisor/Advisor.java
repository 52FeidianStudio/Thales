package cn.thales.aop.advisor;


import cn.thales.aop.advice.Advice;



/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 22:21
 * @Description:
 * 用于整合切入点和功能
 */
public interface Advisor {
    /**
     * 获取Advice
     * @return
     */
    Advice getAdvice();

}
