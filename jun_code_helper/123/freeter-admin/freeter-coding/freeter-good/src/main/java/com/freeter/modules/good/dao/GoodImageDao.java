package com.freeter.modules.good.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.modules.good.entity.GoodImageEntity;
import com.freeter.modules.good.entity.view.GoodImageView;
import com.freeter.modules.good.entity.vo.GoodImageVO;

import org.apache.ibatis.annotations.Param;


/**
 * 商品图片表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-06 11:55:07
 */
public interface GoodImageDao extends BaseMapper<GoodImageEntity> {
	
	List<GoodImageVO> selectListVO(@Param("ew") Wrapper<GoodImageEntity> wrapper);
	
	GoodImageVO selectVO(@Param("ew") Wrapper<GoodImageEntity> wrapper);
	
	
	List<GoodImageView> selectListView(@Param("ew") Wrapper<GoodImageEntity> wrapper);

	GoodImageView selectView(@Param("ew") Wrapper<GoodImageEntity> wrapper);
}
