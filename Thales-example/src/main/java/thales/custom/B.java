package thales.custom;

import cn.thales.ioc.annotation.Component;
import cn.thales.ioc.annotation.Value;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/6 8:43
 * @Description: null
 */
@Component
public class B {
@Value("zqq")
    String name;
//    @Autowired
//    A a;

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public A getA() {
//        return a;
//    }

//    public void setA(A a) {
//        this.a = a;
//    }
}
