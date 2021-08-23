package cn.thales.ioc.beans.support;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/16 21:21
 * @Description: null
 */
public class PropertyValue {
    /**
     * 字段的名字
     * String name = "Thales"里的name
     */
    String name;
    /**
     * 字段的值
     * String name = "Thales"里的"Thales"
     */
    Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
