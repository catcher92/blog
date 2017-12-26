package com.catcher92.blog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ConversionUtil {

    private static final Logger logger = LoggerFactory.getLogger(ConversionUtil.class);

    /**
     * 将from的属性赋值给to
     * @param from
     * @param to
     */
    public static void convert(Object from, Object to) {
        try {
            BeanUtils.copyProperties(from, to);
        } catch (BeansException e) {
            logger.error("bean拷贝失败,异常信息为", e.getLocalizedMessage());
        }
    }

    /**
     * 将from对象转化为指定类型对象，并返回
     * 通过反射调用clazz的无参构造方法，并拷贝属性
     * @param from
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T convert(Object from, Class<T> clazz) {
        T to = null;
        if (null != from) {
            try {
                to = clazz.getDeclaredConstructor().newInstance();
                convert(from, to);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                logger.error("反射生成对象出错,异常信息为", e.getLocalizedMessage());
            }
        }
        return to;
    }

    /**
     * 将传进来的list转换为指定类型的list
     * 如果list为空返回空list
     * @param fromList
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> convertList(List<?> fromList, Class<T> clazz) {
        if (CollectionUtils.isEmpty(fromList)) {
            return Collections.emptyList();
        }
        ArrayList<T> list = new ArrayList<>(fromList.size());
        for (Object from : fromList) {
            if (null != from) {
                list.add(convert(from, clazz));
            }
        }
        return list;
    }
}
