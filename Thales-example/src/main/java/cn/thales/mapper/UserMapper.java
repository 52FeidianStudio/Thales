package cn.thales.mapper;

import cn.thales.entity.Accounts;
import cn.thales.entity.User;
import cn.thales.ioc.annotation.Autowired;
import cn.thales.ioc.annotation.Component;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/24 17:39
 * @Description: null
 */
@Component
public class UserMapper implements IUserMapper {
    @Autowired
    User user;
    @Override
    public String selectUserInfo() {
        return user.toString();
    }

    @Override
    public String selectAccounts() {
        return user.getAcounts().toString();
    }
}
