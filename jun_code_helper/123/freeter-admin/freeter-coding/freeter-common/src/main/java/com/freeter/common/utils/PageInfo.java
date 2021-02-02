package com.freeter.common.utils;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.baomidou.mybatisplus.plugins.Page;
import com.freeter.common.xss.SQLFilter;

public class PageInfo<T> {
	private static final long serialVersionUID = 1L;
    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private int currPage = 1;
    /**
     * 每页条数
     */
    private int limit = 10;

    public PageInfo(JQPageInfo pageInfo) {
    	//分页参数
        if(pageInfo.getPage()!= null){
            currPage = pageInfo.getPage();
        }
        if(pageInfo.getLimit()!= null){
            limit = pageInfo.getLimit();
        }

        if(pageInfo.getOffset() != null) {
    		int offset =  pageInfo.getOffset();
    		currPage = offset / limit + 1;
    	}
    
        String pSidx = 	pageInfo.getSidx();
        pSidx = MPUtil.camelToUnderline(pSidx);
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String sidx = SQLFilter.sqlInject(pSidx);
        String order = SQLFilter.sqlInject(pageInfo.getOrder());
        
      
        //mybatis-plus分页
        this.page = new Page<>(currPage, limit);

        //排序
        if(StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(order)){
            this.page.setOrderByField(sidx);
            this.page.setAsc("ASC".equalsIgnoreCase(order));
        }
    }
    
    
    public Page<T> getPage() {
        return page;
    }

    public int getCurrPage() {
        return currPage;
    }

    public int getLimit() {
        return limit;
    }
}
