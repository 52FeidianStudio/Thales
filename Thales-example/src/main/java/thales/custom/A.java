package thales.custom;


import cn.thales.ioc.annotation.Autowired;
import cn.thales.ioc.annotation.Component;
import cn.thales.ioc.annotation.Value;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/6 8:43
 * @Description: null
 */
@Component
public class A {
    @Value("41")
    private int a;
    private int age;
    private Boolean dead;
    @Autowired
    B build;

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", age=" + age +
                ", dead=" + dead +
                ", build=" + build +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getDead() {
        return dead;
    }

    public void setDead(Boolean dead) {
        this.dead = dead;
    }
}
