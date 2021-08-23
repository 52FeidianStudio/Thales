package cn.thales.ioc.core.io;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/16 21:18
 * @Description: null
 */
public interface ResourceLoader {
    /**
     * 根据location获取Resource
     * @param location
     * @return
     */
    Resource getResource(String location);
}
