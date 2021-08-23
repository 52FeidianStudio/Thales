package cn.thales.aop;

import cn.thales.aop.advice.TargetClassAware;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 22:08
 * @Description:
 * 获取代理对象及一些附加信息
 */
public interface TargetSource extends TargetClassAware {
    /**
     * 获取代理目标实例
     * @return
     */
    Object getTarget();
}
