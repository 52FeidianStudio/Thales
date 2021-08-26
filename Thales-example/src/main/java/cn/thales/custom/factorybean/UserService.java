package cn.thales.custom.factorybean;

import cn.thales.ioc.annotation.Autowired;
import cn.thales.ioc.annotation.Component;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/24 12:13
 * @Description: null
 */
@Component
public class UserService {
    @Autowired
    private IUserMapper userMapper;
    public String selectName(){
        return userMapper.selectName();
    }
}
