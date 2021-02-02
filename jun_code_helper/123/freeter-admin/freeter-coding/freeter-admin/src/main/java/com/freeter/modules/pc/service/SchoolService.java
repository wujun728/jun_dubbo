package com.freeter.modules.pc.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.pc.entity.SchoolEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.pc.entity.vo.SchoolVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.view.SchoolView;


/**
 * 
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 12:40:06
 */
public interface SchoolService extends IService<SchoolEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SchoolVO> selectListVO(Wrapper<SchoolEntity> wrapper);
   	
   	SchoolVO selectVO(@Param("ew") Wrapper<SchoolEntity> wrapper);
   	
   	List<SchoolView> selectListView(Wrapper<SchoolEntity> wrapper);
   	
   	SchoolView selectView(@Param("ew") Wrapper<SchoolEntity> wrapper);
}

