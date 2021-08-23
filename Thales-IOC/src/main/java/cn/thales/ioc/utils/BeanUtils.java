package cn.thales.ioc.utils;

import java.util.Objects;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/20 20:45
 * @Description: null
 */
public class BeanUtils {
    public static  String generateBeanName(String fullName){
        char[] chars = fullName.substring(fullName.lastIndexOf(".")+1).toCharArray();
        chars[0]^=32;
        return String.valueOf(chars);
    }
    public static  String getAbsolutePath(Class< ? > clazz){
       String rootDir = Objects.requireNonNull(clazz.getClassLoader().getResource("")).getPath();
       String otherDir = clazz.getName().replaceAll("\\.","/");
       return (rootDir + otherDir+".class").substring(1);
    }
}
