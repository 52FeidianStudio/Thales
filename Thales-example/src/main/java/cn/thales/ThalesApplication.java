package cn.thales;

import cn.thales.circle.A;
import cn.thales.convert.In;
import cn.thales.ioc.context.AnnotationConfigApplicationContext;
import cn.thales.service.UserService;
import cn.thales.service.UserService2;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/27 17:27
 * @Description: null
 */
public class ThalesApplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("cn.thales");
        UserService userService = (UserService)applicationContext.getBean("userService");
        UserService2 userService2 = (UserService2) applicationContext.getBean("userService2");
        A a = (A) applicationContext.getBean("a");
        System.out.println(a);
        System.out.println(a.getB()+"  "+a.getB().getA());
        System.out.println(userService.selectUserInfo());
        System.out.println(userService.selectUserCounts());
        System.out.println(userService.getBeanFactory());
        System.out.println(userService2.test());
        ;
    }
}
