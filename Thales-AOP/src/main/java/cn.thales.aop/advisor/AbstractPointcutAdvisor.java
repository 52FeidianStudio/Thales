package cn.thales.aop.advisor;

import cn.thales.aop.advice.Advice;
import cn.thales.aop.joinpoint.Pointcut;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 10:22
 * @Description: null
 */
public abstract class AbstractPointcutAdvisor implements PointcutAdvisor{
    private Advice advice;
    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
