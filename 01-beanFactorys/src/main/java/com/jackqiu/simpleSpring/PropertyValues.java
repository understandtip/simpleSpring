package com.jackqiu.simpleSpring;

import java.util.ArrayList;
import java.util.List;

/**
 * 存放某一个Bean的属性集合
 * @author jackqiu
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue propertyValue : propertyValueList) {
            String name = propertyValue.getName();
            if(name.equals(propertyName)){
                return propertyValue;
            }
        }
        return null;
    }
}
