package cn.thales.service;

import cn.thales.ioc.annotation.Autowired;
import cn.thales.ioc.annotation.Component;
import cn.thales.mapper.IUser2Mapper;
import cn.thales.mapper.IUserMapper;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/28 15:07
 * @Description: null
 */
@Component
public class UserService2 {
    @Autowired
    IUser2Mapper userMapper;
    public String test(){
        System.out.println("--------------------");
        return userMapper.getSum();
    }
}
