package com.freeter.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.good.entity.GoodParameterEntity;
import com.freeter.modules.good.entity.view.GoodParameterView;
import com.freeter.modules.good.entity.vo.GoodParameterVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 商品参数表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-07 08:56:45
 */
public interface GoodParameterService extends IService<GoodParameterEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodParameterVO> selectListVO(Wrapper<GoodParameterEntity> wrapper);
   	
   	GoodParameterVO selectVO(@Param("ew") Wrapper<GoodParameterEntity> wrapper);
   	
   	List<GoodParameterView> selectListView(Wrapper<GoodParameterEntity> wrapper);
   	
   	GoodParameterView selectView(@Param("ew") Wrapper<GoodParameterEntity> wrapper);
}

