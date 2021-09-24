package com.zdj.copyproperties;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdj
 * @date 2019/11/20
 */
public class ResponseUtil {

    /**
     * copy属性
     * @param source
     * @param clazz
     * @return
     */
    public static <T,C> C converter(T source,Class<C> clazz){
        C target = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <T,C> List<C> converterListToList(List<T> source, Class<C> clazz){
        List<C> targetList = new ArrayList<>(source.size());
        if (!CollectionUtils.isEmpty(source)){
            for (T data:source) {
                C target = converter(data, clazz);
                targetList.add(target);
            }
        }
        return targetList;
    }
}
