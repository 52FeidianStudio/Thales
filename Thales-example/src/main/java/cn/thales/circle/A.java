package cn.thales.circle;

import cn.thales.ioc.annotation.Autowired;
import cn.thales.ioc.annotation.Component;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/27 21:09
 * @Description: null
 */
@Component
public class A {
    @Autowired
    B b;
}
