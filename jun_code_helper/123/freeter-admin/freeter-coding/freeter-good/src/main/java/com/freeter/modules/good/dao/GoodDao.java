package com.freeter.modules.good.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.view.GoodView;
import com.freeter.modules.good.entity.vo.GoodVO;


/**
 * 商品表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 09:01:38
 */
public interface GoodDao extends BaseMapper<GoodEntity> {
	
	List<GoodVO> selectListVO(@Param("ew") Wrapper<GoodEntity> wrapper);
	
	GoodVO selectVO(@Param("ew") Wrapper<GoodEntity> wrapper);
	
	List<GoodView> selectListView(@Param("ew") Wrapper<GoodEntity> wrapper);

	GoodView selectView(@Param("ew") Wrapper<GoodEntity> wrapper);
	
	List<GoodView> selectCategoryChannelByGood(Page page,@Param("ew") Wrapper<GoodEntity> wrapper);
}
