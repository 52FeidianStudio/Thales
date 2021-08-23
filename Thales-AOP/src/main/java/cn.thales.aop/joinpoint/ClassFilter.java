package cn.thales.aop.joinpoint;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 21:57
 * @Description:
 * 匹配对应的类
 */
public interface ClassFilter {
    /**
     * 给定类型是否匹配
     * @param clazz
     * @return
     */
    boolean matches(Class< ? > clazz);
}
