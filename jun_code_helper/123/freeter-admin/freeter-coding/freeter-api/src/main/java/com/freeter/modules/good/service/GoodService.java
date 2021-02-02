package com.freeter.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.vo.GoodVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 商品表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:00
 */
public interface GoodService extends IService<GoodEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodVO> selectListVO(Wrapper<GoodEntity> wrapper);
   	
   	GoodVO selectVO( Wrapper<GoodEntity> wrapper);
   	
	List<GoodVO> selectGoodAndGoodAttr(Wrapper<GoodEntity> wrapper);

}

