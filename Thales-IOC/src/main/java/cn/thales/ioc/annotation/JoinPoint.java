package cn.thales.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 16:14
 * @Description: null
 */
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface JoinPoint {
    String classPattern() default"";
    String methodPattern() default"";
}
