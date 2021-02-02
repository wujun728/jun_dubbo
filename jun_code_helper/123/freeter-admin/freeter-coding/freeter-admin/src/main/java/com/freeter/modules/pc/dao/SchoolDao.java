package com.freeter.modules.pc.dao;

import com.freeter.modules.pc.entity.SchoolEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.vo.SchoolVO;
import com.freeter.modules.pc.entity.view.SchoolView;


/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 12:40:06
 */
public interface SchoolDao extends BaseMapper<SchoolEntity> {
	
	List<SchoolVO> selectListVO(@Param("ew") Wrapper<SchoolEntity> wrapper);
	
	SchoolVO selectVO(@Param("ew") Wrapper<SchoolEntity> wrapper);
	
	
	List<SchoolView> selectListView(@Param("ew") Wrapper<SchoolEntity> wrapper);

	SchoolView selectView(@Param("ew") Wrapper<SchoolEntity> wrapper);
}
