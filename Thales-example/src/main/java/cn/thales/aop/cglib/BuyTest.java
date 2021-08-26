package cn.thales.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/26 12:22
 * @Description: null
 */
public class BuyTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Buy.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            if(method.getName().equals("buyOne")){
                System.out.println("hello");
                methodProxy.invokeSuper(o,objects);
            }else {
                methodProxy.invokeSuper(o,objects);
            }

//            method.invoke(o,objects);
            return o;
        });
        Buy o = (Buy)enhancer.create();
        o.buyOne();
        o.buyTwo();
    }

}
