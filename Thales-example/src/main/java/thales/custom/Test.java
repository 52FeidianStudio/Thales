package thales.custom;

import cn.thales.example.MyEvent;
import cn.thales.ioc.context.AnnotationConfigApplicationContext;
import cn.thales.ioc.utils.BeanUtils;

import java.io.IOException;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/7/24 18:54
 * @Description: null
 */
public class Test {
    public static void main(String[] args) throws IOException {
        testIoc();
    }
    public static void testIoc() throws IOException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("cn.thales");
        System.out.println(annotationConfigApplicationContext.getBean("a"));
        annotationConfigApplicationContext.publishEvent(new MyEvent(annotationConfigApplicationContext));
        System.out.println(BeanUtils.getAbsolutePath(A.class));

    }
}
