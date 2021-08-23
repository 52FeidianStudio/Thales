package cn.thales.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/20 16:57
 * @Description: null
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Value {
    String value();
}
