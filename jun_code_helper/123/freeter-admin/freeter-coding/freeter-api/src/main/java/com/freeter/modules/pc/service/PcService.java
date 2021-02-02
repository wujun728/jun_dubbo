package com.freeter.modules.pc.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.pc.entity.PcEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.pc.entity.vo.PcVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.view.PcView;


/**
 * 
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 14:56:33
 */
public interface PcService extends IService<PcEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PcVO> selectListVO(Wrapper<PcEntity> wrapper);
   	
   	PcVO selectVO(@Param("ew") Wrapper<PcEntity> wrapper);
   	
   	List<PcView> selectListView(Wrapper<PcEntity> wrapper);
   	
   	PcView selectView(@Param("ew") Wrapper<PcEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PcEntity> wrapper);
}

