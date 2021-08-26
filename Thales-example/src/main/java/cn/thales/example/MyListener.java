package cn.thales.example;

import cn.thales.ioc.annotation.Component;
import cn.thales.ioc.context.ApplicationListener;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 16:05
 * @Description: null
 */
@Component
public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("hhhhhhhhhhhhhhhhhh");

    }


}
