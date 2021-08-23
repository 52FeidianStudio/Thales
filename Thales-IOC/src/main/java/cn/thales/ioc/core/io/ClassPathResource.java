package cn.thales.ioc.core.io;

import java.io.File;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/16 21:17
 * @Description: null
 */
public class ClassPathResource extends AbstractResource {
    private final String path;

    private ClassLoader classLoader;

    private Class<?> clazz;

    public ClassPathResource(String path, ClassLoader classLoader, Class<?> clazz) {
        this.path = path;
        this.classLoader = classLoader;
        this.clazz = clazz;
    }

    @Override
    public File getFile() {
        return null;
    }

    public String getPath() {
        return path;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
