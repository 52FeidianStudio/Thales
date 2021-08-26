package cn.thales.aop.advice;

import cn.thales.aop.MethodBeforeAdviceInterceptor;
import cn.thales.aop.MethodInterceptor;
import cn.thales.aop.TargetSource;
import cn.thales.aop.advisor.Advisor;
import cn.thales.aop.advisor.PointcutAdvisor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 22:10
 * @Description: null
 */
public class AdvisedSupport {
    private  TargetSource targetSource;
    private List<MethodInterceptor> methodInterceptors = new ArrayList<>();
    private List<PointcutAdvisor> advisors = new ArrayList<>();

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public List<MethodInterceptor> getMethodInterceptor() {
        return methodInterceptors;
    }

    public void addMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptors.add(methodInterceptor);
    }

    public List<PointcutAdvisor> getAdvisor() {
        return advisors;
    }

    public void addAdvisor(PointcutAdvisor advisor) {
        MethodBeforeAdviceInterceptor methodBeforeAdviceInterceptor = new MethodBeforeAdviceInterceptor();
        methodBeforeAdviceInterceptor.setAdvice((MethodBeforeAdvice) advisor.getAdvice());
        addMethodInterceptor(methodBeforeAdviceInterceptor);
        this.advisors.add(advisor);
    }
}
