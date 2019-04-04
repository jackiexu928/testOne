package com.jackie.testOne.util;

import com.jackie.testOne.common.TestOneCodeEnum;
import com.jackie.testOne.common.TestOneException;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/4/2
 */
public class ValidtionUitl {
    public static void validation(Object object) {
        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
                if (f.get(object) == null) {
                    throw new TestOneException(TestOneCodeEnum.ILLGAL_ARGUMENT, f.get(object).getClass().getName());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
