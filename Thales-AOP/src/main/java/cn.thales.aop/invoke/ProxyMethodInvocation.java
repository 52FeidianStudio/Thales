package cn.thales.aop.invoke;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/25 12:42
 * @Description: null
 */
public interface ProxyMethodInvocation extends MethodInvocation{
    /**
     * 得到代理方法本身
     * @return
     */
    Object getProxy();
}
