package com.jackqiu.simpleSpring;

/**
 * 用来存放Bean的每一个属性名和属性值的类
 * @author jackqiu
 */
public class PropertyValue {
    private String name;

    public Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
