package cn.thales.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 17:36
 * @Description:
 * 标识将该类加入类管理容器中
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Component {
    String value() default "";
}
