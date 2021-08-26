package cn.thales.aop;

import cn.thales.aop.advice.AdvisedSupport;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 9:59
 * @Description: null
 */
public class ProxyFactory {
    AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return createProxy().getProxy();
    }
    private AopProxy createProxy() {
        return new CglibAopProxy(advisedSupport);
    }
}
