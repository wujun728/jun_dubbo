package com.freeter.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.good.entity.GoodDetailEntity;
import com.freeter.modules.good.entity.view.GoodDetailView;
import com.freeter.modules.good.entity.vo.GoodDetailVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 商品描述表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-07 15:43:06
 */
public interface GoodDetailService extends IService<GoodDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodDetailVO> selectListVO(Wrapper<GoodDetailEntity> wrapper);
   	
   	GoodDetailVO selectVO(@Param("ew") Wrapper<GoodDetailEntity> wrapper);
   	
   	List<GoodDetailView> selectListView(Wrapper<GoodDetailEntity> wrapper);
   	
   	GoodDetailView selectView(@Param("ew") Wrapper<GoodDetailEntity> wrapper);
}

