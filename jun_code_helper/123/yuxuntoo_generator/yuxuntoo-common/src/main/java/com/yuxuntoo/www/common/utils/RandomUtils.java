package com.yuxuntoo.www.common.utils;

import java.util.UUID;

/**
 * @Author Camel
 * @Date 2013/10/24 15:52
 * @Version 1.0
 */
public class RandomUtils {

    public static String uuidString(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
