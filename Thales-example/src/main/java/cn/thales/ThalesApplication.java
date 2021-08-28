package cn.thales;

import cn.thales.convert.In;
import cn.thales.ioc.context.AnnotationConfigApplicationContext;
import cn.thales.service.UserService;

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
        System.out.println(userService.selectUserInfo());
        System.out.println(userService.selectUserCounts());
        Object object =In.class.newInstance();
        Field[] declaredFields = In.class.getDeclaredFields();
        declaredFields[0].setAccessible(true);

//        declaredFields[0].set(object,10);
//        System.out.println();
    }
}
