package cn.thales;

import cn.thales.ioc.context.AnnotationConfigApplicationContext;
import cn.thales.service.UserService;

import java.io.IOException;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/27 17:27
 * @Description: null
 */
public class ThalesApplication {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("cn.thales");
        UserService userService = (UserService)applicationContext.getBean("userService");
        System.out.println(userService.selectUserInfo());
        System.out.println(userService.selectUserCounts());
    }
}
