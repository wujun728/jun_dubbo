package com.freeter.modules.pc.controller;

import java.util.Arrays;
import java.util.Map;

import com.freeter.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.freeter.modules.pc.entity.StudentEntity;
import com.freeter.modules.pc.entity.view.StudentView;

import com.freeter.modules.pc.service.StudentService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.utils.MPUtil;



/**
 * 
 * 后端接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 15:47:02
 */
@RestController
@RequestMapping("pc/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    @RequiresPermissions("pc:student:list")
    public R page(@RequestParam Map<String, Object> params,StudentEntity student){
 
        EntityWrapper< StudentEntity> ew = new EntityWrapper< StudentEntity>();
      	ew.allEq(MPUtil.allEQMapPre( student, "student")); 
    	PageUtils page = studentService.queryPage(params, ew);
    
        return R.ok().put("page", page);
        
    }

	/**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("pc:student:list")
    public R list( StudentEntity student){
       	EntityWrapper<  StudentEntity> ew = new EntityWrapper<  StudentEntity>();
      	ew.allEq(MPUtil.allEQMapPre( student, "student")); 
        return R.ok().put("data",  studentService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    @RequiresPermissions("pc:student:info")
    public R query(StudentEntity student){
        EntityWrapper< StudentEntity> ew = new EntityWrapper< StudentEntity>();
 		ew.allEq(MPUtil.allEQMapPre( student, "student")); 
		StudentView  studentView =  studentService.selectView(ew);
		return R.ok("查询成功").put("data",  studentView);
    }
	
    /**
     * 信息
     */
    @RequestMapping("/info/{studentId}")
    @RequiresPermissions("pc:student:info")
    public R info(@PathVariable("studentId") Long studentId){
        StudentEntity student = studentService.selectById(studentId);

        return R.ok().put("student", student);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pc:student:save")
    public R save(@RequestBody StudentEntity student){
    	ValidatorUtils.validateEntity(student);
        studentService.insert(student);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pc:student:update")
    public R update(@RequestBody StudentEntity student){
        ValidatorUtils.validateEntity(student);
        studentService.updateAllColumnById(student);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pc:student:delete")
    public R delete(@RequestBody Long[] studentIds){
        studentService.deleteBatchIds(Arrays.asList(studentIds));

        return R.ok();
    }

}
