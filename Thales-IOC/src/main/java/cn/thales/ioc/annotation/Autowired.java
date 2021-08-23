package cn.thales.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 17:43
 * @Description: null
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Autowired {
}
