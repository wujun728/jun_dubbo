package com.freeter.modules.adverts.dao;

import com.freeter.modules.adverts.entity.AdvertsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.adverts.entity.vo.AdvertsVO;
import com.freeter.modules.adverts.entity.view.AdvertsView;


/**
 * 广告位表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 12:36:59
 */
public interface AdvertsDao extends BaseMapper<AdvertsEntity> {
	
	List<AdvertsVO> selectListVO(@Param("ew") Wrapper<AdvertsEntity> wrapper);
	
	AdvertsVO selectVO(@Param("ew") Wrapper<AdvertsEntity> wrapper);
	
	
	List<AdvertsView> selectListView(@Param("ew") Wrapper<AdvertsEntity> wrapper);

	List<AdvertsView> selectListView(Pagination page,@Param("ew") Wrapper<AdvertsEntity> wrapper);
	
	AdvertsView selectView(@Param("ew") Wrapper<AdvertsEntity> wrapper);
}
