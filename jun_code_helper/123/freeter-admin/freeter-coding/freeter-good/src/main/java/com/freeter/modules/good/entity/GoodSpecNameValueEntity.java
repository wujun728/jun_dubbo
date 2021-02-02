package com.freeter.modules.good.entity;

import java.util.List;
import java.util.Map;

/**
 * 规格名称值类
 */
public class GoodSpecNameValueEntity {
    public GoodSpecNameValueEntity(){

    }


    /**
     * 类别规格id
     */
    private Integer categorySpecId;

    /**
     * 规格名称
     */
    private String specName;

    /**
     * 规格值组合
     * Map里面包括 GoodSpecValueId,specValue
     */
    private List<Map> mapList;

    public Integer getCategorySpecId() {
        return categorySpecId;
    }

    public String getSpecName() {
        return specName;
    }


    public void setCategorySpecId(Integer categorySpecId) {
        this.categorySpecId = categorySpecId;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public List<Map> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map> mapList) {
        this.mapList = mapList;
    }
}
