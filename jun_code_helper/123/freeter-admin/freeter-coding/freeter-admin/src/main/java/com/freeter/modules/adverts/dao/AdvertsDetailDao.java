package com.freeter.modules.adverts.dao;

import com.freeter.modules.adverts.entity.AdvertsDetailEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.adverts.entity.vo.AdvertsDetailVO;
import com.freeter.modules.adverts.entity.view.AdvertsDetailView;


/**
 * 广告位详情
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 12:36:59
 */
public interface AdvertsDetailDao extends BaseMapper<AdvertsDetailEntity> {
	
	List<AdvertsDetailVO> selectListVO(@Param("ew") Wrapper<AdvertsDetailEntity> wrapper);
	
	AdvertsDetailVO selectVO(@Param("ew") Wrapper<AdvertsDetailEntity> wrapper);
	
	
	List<AdvertsDetailView> selectListView(@Param("ew") Wrapper<AdvertsDetailEntity> wrapper);

	List<AdvertsDetailView> selectListView(Pagination page,@Param("ew") Wrapper<AdvertsDetailEntity> wrapper);
	
	AdvertsDetailView selectView(@Param("ew") Wrapper<AdvertsDetailEntity> wrapper);
}
