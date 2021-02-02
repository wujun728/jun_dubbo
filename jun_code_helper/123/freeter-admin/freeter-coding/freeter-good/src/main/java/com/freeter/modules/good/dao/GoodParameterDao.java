package com.freeter.modules.good.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.modules.good.entity.GoodParameterEntity;
import com.freeter.modules.good.entity.view.GoodParameterView;
import com.freeter.modules.good.entity.vo.GoodParameterVO;

import org.apache.ibatis.annotations.Param;


/**
 * 商品参数表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-07 08:56:45
 */
public interface GoodParameterDao extends BaseMapper<GoodParameterEntity> {
	
	List<GoodParameterVO> selectListVO(@Param("ew") Wrapper<GoodParameterEntity> wrapper);
	
	GoodParameterVO selectVO(@Param("ew") Wrapper<GoodParameterEntity> wrapper);
	
	
	List<GoodParameterView> selectListView(@Param("ew") Wrapper<GoodParameterEntity> wrapper);

	GoodParameterView selectView(@Param("ew") Wrapper<GoodParameterEntity> wrapper);
}
