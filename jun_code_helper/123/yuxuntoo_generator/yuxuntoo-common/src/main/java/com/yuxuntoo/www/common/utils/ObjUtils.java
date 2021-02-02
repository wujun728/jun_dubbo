package com.yuxuntoo.www.common.utils;

import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;
import java.util.Map;

/**
 * 对象工具类
 */
public class ObjUtils {

    /**
     * map 转为对象
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        }
        Object obj = beanClass.newInstance();
        BeanUtils.populate(obj,map);
        return obj;
    }

    /**
     * 将对象转为map集合
     * @param obj
     * @return
     */
    public static Map<?,?> objToMap(Object obj){
        if (obj == null) {
            return null;
        }
        return new BeanMap(obj);
    }

    /**
     * 排序后的List分页
     * @param list
     * @param pageSize
     * @param pageNo
     * @return
     */
    public static <T> PageInfo<T> getListForPage(List<T> list, Integer pageSize, Integer pageNo){
        PageInfo<T> pageInfo = new PageInfo<>();
        if(list == null || list.isEmpty() || 0 >= list.size()){
            pageInfo.setPageNum(pageNo);
            pageInfo.setPageSize(pageSize);
            pageInfo.setTotal(0);
            pageInfo.setPages(0);
            return pageInfo;
        }
        int totals = list.size();
        int pages = 0;
        List<T> subList;
        int flag = totals % pageSize;
        if (flag > 0) {
            pages = totals / pageSize + 1;
        } else {
            pages = totals / pageSize;
        }
        if (flag == 0) {
            subList = list.subList((pageNo - 1) * pageSize, pageSize * (pageNo));
        } else {
            if (pageNo == pages) {
                subList = list.subList((pageNo - 1) * pageSize, totals);
            } else {
                subList = list.subList((pageNo - 1) * pageSize, pageSize * (pageNo));
            }
        }
        pageInfo.setPageNum(pageNo);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(totals);
        pageInfo.setPages(pages);
        pageInfo.setList(subList);
        return pageInfo;
    }
}
