package cn.thales.aop.advice;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 22:05
 * @Description:
 * 获取要代理的目标
 */
public interface TargetClassAware {
    /**
     * 获取对应的目标
     * @return
     */
    Class< ? > getTargetClass();
}
