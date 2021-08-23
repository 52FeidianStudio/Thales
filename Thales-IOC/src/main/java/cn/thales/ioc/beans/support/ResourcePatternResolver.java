package cn.thales.ioc.beans.support;

import cn.thales.ioc.core.io.Resource;
import cn.thales.ioc.core.io.ResourceLoader;

import java.util.List;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 16:09
 * @Description: null
 */
public interface ResourcePatternResolver extends ResourceLoader {
    String CLASSPATH_ALL_URL_PREFIX = "classpath*:";
    /**
     *根据对应规则去指定路径匹配特定条件的Resource
     * @param location
     * @return
     */
    List<? extends Resource> getResources(String location);
}
