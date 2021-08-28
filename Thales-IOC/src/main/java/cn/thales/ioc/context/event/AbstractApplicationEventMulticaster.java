package cn.thales.ioc.context.event;

import cn.thales.ioc.beans.factory.BeanFactory;
import cn.thales.ioc.beans.factory.BeanFactoryAware;
import cn.thales.ioc.beans.factory.config.ConfigurableBeanFactory;
import cn.thales.ioc.context.ApplicationListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/23 12:15
 * @Description:
 * 对于事件广播器的模板实现
 * 包括
 * 1. 删除监听器
 * 2. 添加监听器
 * 3. 判断改监听器是否对该事件感兴趣
 * 4. 获取对特定类型感兴趣的监听器
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {
    Set<ApplicationListener<ApplicationEvent>> applicationListenerSet = new HashSet<>();
    ConfigurableBeanFactory beanFactory;
    @Override
    public  void setBeanFactory(BeanFactory  factory){
        this.beanFactory = (ConfigurableBeanFactory) beanFactory;
    } ;


    @Override
    public void addApplicationListener(ApplicationListener listener) {
        applicationListenerSet.add(listener);

    }

    @Override
    public void removeApplicationListener(ApplicationListener listener) {
        applicationListenerSet.remove(listener);
    }

    /**
     * 是通过每个监听器实例化时的泛型参数来判断的,也就是说,此处,一个监听器只能监听一类事件
     * @param listener
     * @param event
     * @return
     */
    public boolean supportEvent(ApplicationListener<ApplicationEvent> listener,ApplicationEvent event){
        //先获取Class对象
        Class<? extends ApplicationListener> listenerClass = listener.getClass();

        //获取其实现的所有接口(包括泛型信息)
        Type[] genericInterfaces = listenerClass.getGenericInterfaces();
        for (Type genericInterface:genericInterfaces){
            //判断是否为泛型接口
            if(genericInterface instanceof ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
                //得到所有泛型参数
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for(Type actualTypeArgument:actualTypeArguments){
                    try {
                        Class<?> aClass = Class.forName(actualTypeArgument.getTypeName());
                        //判断感兴趣的事件类型是否与传入事件相同,或者是其父类
                        if(aClass.isAssignableFrom(event.getClass())){
                            return true;
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        return false;
    }

    protected Collection<ApplicationListener<ApplicationEvent>> getApplicationListeners(ApplicationEvent event){
        ArrayList<ApplicationListener<ApplicationEvent>> applicationListeners = new ArrayList<>();
        for (ApplicationListener< ApplicationEvent > listener :applicationListenerSet){
            if(supportEvent(listener,event)){
                applicationListeners.add(listener);
            }
        }
        return  applicationListeners;
    }


}
