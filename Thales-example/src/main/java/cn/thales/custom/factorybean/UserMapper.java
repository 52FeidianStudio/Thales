package cn.thales.custom.factorybean;

import cn.thales.ioc.annotation.Component;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/24 17:39
 * @Description: null
 */
//@Component
public class UserMapper implements IUserMapper {
    @Override
    public String selectName() {
        return "hhhhhhh";
    }
}
