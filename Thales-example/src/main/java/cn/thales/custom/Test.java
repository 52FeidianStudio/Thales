package cn.thales.custom;

import cn.thales.custom.aop.User;
import cn.thales.custom.factorybean.UserService;
import cn.thales.example.MyEvent;
import cn.thales.ioc.annotation.Autowired;
import cn.thales.ioc.annotation.Component;
import cn.thales.ioc.context.AnnotationConfigApplicationContext;
import cn.thales.ioc.utils.BeanUtils;

import java.io.IOException;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/7/24 18:54
 * @Description: null
 */
@Component
public class Test {
    @Autowired
    UserService userService;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Test().testIoc();
    }
    public  void testIoc() throws IOException, ClassNotFoundException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("cn.thales.custom.aop");
        Object user = annotationConfigApplicationContext.getBean("user");
        ((User)user).sayHello();
//        System.out.println(annotationConfigApplicationContext.getBean("a"));
//        annotationConfigApplicationContext.publishEvent(new MyEvent(annotationConfigApplicationContext));
//        System.out.println(BeanUtils.getAbsolutePath(A.class));
//        System.out.println(userService.selectName());


    }
}
