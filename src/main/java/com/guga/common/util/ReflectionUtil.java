package com.guga.common.util;

import sun.reflect.FieldAccessor;

import java.lang.reflect.Field;

/**
 * Created by guga
 */
public class ReflectionUtil {

    ReflectionUtil(Class c){

    }

    public void attributeValue(String attribute){
        try {
            Field a = Field.class.getDeclaredField(attribute);
            a.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
