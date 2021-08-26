package cn.thales.aop;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 13:10
 * @Description: null
 */
public class SimpleBeanTargetSource implements TargetSource{
    Object target;
    Class targetClass;
    @Override
    public Object getTarget() {
        return target;
    }

    @Override
    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }
}
