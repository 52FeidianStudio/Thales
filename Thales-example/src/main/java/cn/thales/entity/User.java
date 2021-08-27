package cn.thales.entity;

import cn.thales.ioc.annotation.Autowired;
import cn.thales.ioc.annotation.Component;
import cn.thales.ioc.annotation.Value;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/27 17:30
 * @Description: null
 */
@Component
public class User {
    @Value("小明")
    String name;
    @Value("1")
    int age;
    @Autowired
    Accounts acounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Accounts getAcounts() {
        return acounts;
    }

    public void setAcounts(Accounts acounts) {
        this.acounts = acounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acounts=" + acounts +
                '}';
    }
}

