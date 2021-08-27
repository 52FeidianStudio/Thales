package cn.thales.aop.advisor;

import cn.thales.aop.advice.Advice;
import cn.thales.aop.joinpoint.JdkRegexMethodPointcut;
import cn.thales.aop.joinpoint.Pointcut;

import java.io.Serializable;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 10:34
 * @Description:
 * 基于正则表达式的Advisor
 */
public class RegexMethodPointcutAdvisor extends AbstractPointcutAdvisor {
    JdkRegexMethodPointcut pointcut = new JdkRegexMethodPointcut();
    private String[] patterns;


    public RegexMethodPointcutAdvisor() {
    }
    public RegexMethodPointcutAdvisor(Advice advice) {
        setAdvice(advice);
    }


    public RegexMethodPointcutAdvisor(String pattern, Advice advice) {
        setPattern(pattern);
        setAdvice(advice);
    }

    public RegexMethodPointcutAdvisor(String[] patterns, Advice advice) {
        setPatterns(patterns);
        setAdvice(advice);
    }

    public void setPattern(String pattern) {
        setPatterns(pattern);
    }

    public void setPatterns(String... patterns) {
        this.patterns = patterns;
        pointcut.initPatternRepresentation(patterns);

    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }
}
