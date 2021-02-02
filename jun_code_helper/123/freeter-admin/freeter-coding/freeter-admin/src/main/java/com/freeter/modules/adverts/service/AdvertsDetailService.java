package com.freeter.modules.adverts.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.adverts.entity.AdvertsDetailEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.adverts.entity.vo.AdvertsDetailVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.adverts.entity.view.AdvertsDetailView;
import com.freeter.common.utils.PageInfo;


/**
 * 广告位详情
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 12:36:59
 */
public interface AdvertsDetailService extends IService<AdvertsDetailEntity> {

    
   	List<AdvertsDetailVO> selectListVO(Wrapper<AdvertsDetailEntity> wrapper);
   	
   	AdvertsDetailVO selectVO(@Param("ew") Wrapper<AdvertsDetailEntity> wrapper);
   	
   	List<AdvertsDetailView> selectListView(Wrapper<AdvertsDetailEntity> wrapper);
   	
   	AdvertsDetailView selectView(@Param("ew") Wrapper<AdvertsDetailEntity> wrapper);
   	
   	PageUtils queryPage(PageInfo pageInfo,Wrapper<AdvertsDetailEntity> wrapper);
}

