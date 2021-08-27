package cn.thales.entity;

import cn.thales.ioc.annotation.Component;
import cn.thales.ioc.annotation.Value;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/27 17:32
 * @Description: null
 */
@Component
public class Accounts {
    @Value("zqq")
    String username;
    @Value("123456")
    String password;

    @Override
    public String toString() {
        return "Accounts{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
