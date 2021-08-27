package cn.thales.mapper;

import cn.thales.entity.Accounts;
import cn.thales.ioc.annotation.Component;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/24 12:13
 * @Description: null
 */

public interface IUserMapper {
    String selectUserInfo();
    String selectAccounts();
}
