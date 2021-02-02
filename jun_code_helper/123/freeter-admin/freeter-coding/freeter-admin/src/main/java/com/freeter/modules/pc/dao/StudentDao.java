package com.freeter.modules.pc.dao;

import com.freeter.modules.pc.entity.StudentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.vo.StudentVO;
import com.freeter.modules.pc.entity.view.StudentView;


/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 15:47:02
 */
public interface StudentDao extends BaseMapper<StudentEntity> {
	
	List<StudentVO> selectListVO(@Param("ew") Wrapper<StudentEntity> wrapper);
	
	StudentVO selectVO(@Param("ew") Wrapper<StudentEntity> wrapper);
	
	
	List<StudentView> selectListView(@Param("ew") Wrapper<StudentEntity> wrapper);

	List<StudentView> selectListView(Pagination page,@Param("ew") Wrapper<StudentEntity> wrapper);
	
	StudentView selectView(@Param("ew") Wrapper<StudentEntity> wrapper);
}
