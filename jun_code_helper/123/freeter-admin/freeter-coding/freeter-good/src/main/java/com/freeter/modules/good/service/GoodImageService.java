package com.freeter.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.good.entity.GoodImageEntity;
import com.freeter.modules.good.entity.view.GoodImageView;
import com.freeter.modules.good.entity.vo.GoodImageVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 商品图片表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-06 11:55:07
 */
public interface GoodImageService extends IService<GoodImageEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodImageVO> selectListVO(Wrapper<GoodImageEntity> wrapper);
   	
   	GoodImageVO selectVO(@Param("ew") Wrapper<GoodImageEntity> wrapper);
   	
   	List<GoodImageView> selectListView(Wrapper<GoodImageEntity> wrapper);
   	
   	GoodImageView selectView(@Param("ew") Wrapper<GoodImageEntity> wrapper);
}

