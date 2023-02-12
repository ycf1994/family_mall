package com.family.mall.util;

import org.apache.commons.beanutils.BeanUtils;

public class MallUtil {
    public static <V>V convert(Object o,Class<V> cls ){
        if(o == null){
            return null;
        }
        try {
            Object dest = cls.newInstance();
            BeanUtils.copyProperties(dest,o);
            return (V) dest;
        } catch (Exception e) {
            return null;
        }
    }
}
