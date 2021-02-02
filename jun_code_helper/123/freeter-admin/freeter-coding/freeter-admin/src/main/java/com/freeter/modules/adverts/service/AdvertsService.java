package com.freeter.modules.adverts.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.adverts.entity.AdvertsEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.adverts.entity.vo.AdvertsVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.adverts.entity.view.AdvertsView;
import com.freeter.common.utils.PageInfo;


/**
 * 广告位表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 12:36:59
 */
public interface AdvertsService extends IService<AdvertsEntity> {

    
   	List<AdvertsVO> selectListVO(Wrapper<AdvertsEntity> wrapper);
   	
   	AdvertsVO selectVO(@Param("ew") Wrapper<AdvertsEntity> wrapper);
   	
   	List<AdvertsView> selectListView(Wrapper<AdvertsEntity> wrapper);
   	
   	AdvertsView selectView(@Param("ew") Wrapper<AdvertsEntity> wrapper);
   	
   	PageUtils queryPage(PageInfo pageInfo,Wrapper<AdvertsEntity> wrapper);
}

