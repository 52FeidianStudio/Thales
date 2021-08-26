package cn.thales.custom.aop;

import cn.thales.ioc.annotation.Component;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 16:51
 * @Description: null
 */
@Component
public class User {
    public String sayHello(){
        System.out.println("hello");
        return "dddd";
    }

}
