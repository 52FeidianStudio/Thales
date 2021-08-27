package cn.thales.service;

import cn.thales.entity.Accounts;
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
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public String selectUserInfo(){
        return userMapper.selectUserInfo();
    }
    public String selectUserCounts(){
        return userMapper.selectAccounts().toString();
    }
}
