package cn.thales.ioc.context;

import cn.thales.ioc.beans.factory.ListableBeanFactory;
import cn.thales.ioc.beans.support.ResourcePatternResolver;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/17 16:59
 * @Description:
 * 集成了BeanFactory以及一些附加的功能
 */
public interface ApplicationContext extends ListableBeanFactory, ResourcePatternResolver {
}
