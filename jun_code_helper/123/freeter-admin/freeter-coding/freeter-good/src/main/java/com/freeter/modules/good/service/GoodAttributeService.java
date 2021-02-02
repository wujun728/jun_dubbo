package com.freeter.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.good.entity.GoodAttributeEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.good.entity.vo.GoodAttributeVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.good.entity.view.GoodAttributeView;


/**
 * 商品属性表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-30 17:28:16
 */
public interface GoodAttributeService extends IService<GoodAttributeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodAttributeVO> selectListVO(Wrapper<GoodAttributeEntity> wrapper);
   	
   	GoodAttributeVO selectVO(@Param("ew") Wrapper<GoodAttributeEntity> wrapper);
   	
   	List<GoodAttributeView> selectListView(Wrapper<GoodAttributeEntity> wrapper);
   	
   	GoodAttributeView selectView(@Param("ew") Wrapper<GoodAttributeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GoodAttributeEntity> wrapper);
}

