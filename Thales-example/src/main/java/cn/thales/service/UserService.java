package cn.thales.service;

import cn.thales.entity.Accounts;
import cn.thales.ioc.beans.factory.BeanFactory;
import cn.thales.ioc.beans.factory.BeanFactoryAware;
import cn.thales.mapper.IUserMapper;
import cn.thales.ioc.annotation.Autowired;
import cn.thales.ioc.annotation.Component;
import cn.thales.mapper.UserMapper;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/24 12:13
 * @Description: null
 */
@Component
public class UserService implements BeanFactoryAware {
    BeanFactory beanFactory;
    @Autowired
    private UserMapper userMapper;
    public String selectUserInfo(){
        return userMapper.selectUserInfo();
    }
    public String selectUserCounts(){
        return userMapper.selectAccounts().toString();
    }

    @Override
    public void setBeanFactory(BeanFactory factory) {
        this.beanFactory = factory;

    }
    public BeanFactory getBeanFactory() {
        return this.beanFactory;
    }
}
