package com.freeter.modules.expressCompany.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.freeter.common.utils.Query;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.expressCompany.entity.ExpressCompanyEntity;
import com.freeter.modules.expressCompany.entity.view.ExpressCompanySearch;
import com.freeter.modules.expressCompany.entity.view.ExpressCompanyView;
import com.freeter.modules.expressCompany.service.ExpressCompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-06 13:08:58
 */
@RestController
@RequestMapping("expressCompany")
@Api(tags="接口")
public class ExpressCompanyController {
    @Autowired
    private ExpressCompanyService expressCompanyService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @ApiOperation("快递公司列表")
    public R list(@RequestParam Map<String, Object> params){
        EntityWrapper<ExpressCompanyEntity> expressCompanyEntityWrapper=new EntityWrapper<ExpressCompanyEntity>();
        PageUtils page=expressCompanyService.queryPage(params);
        return R.ok().put("page",page);
    }
    /**
     * 所有快递公司列表
     */
    @RequestMapping("all")
    public R all(){
        EntityWrapper<ExpressCompanyEntity> expressCompanyEntityWrapper=new EntityWrapper<ExpressCompanyEntity>();
        List<ExpressCompanyEntity> expressCompanyEntityList=expressCompanyService.selectList(expressCompanyEntityWrapper);
        return R.ok().put("data",expressCompanyEntityList);
    }
    /**
     * 查询
     */
    @GetMapping("/search")
    @ApiOperation("查询")
    public R search(ExpressCompanySearch expressCompanySearch){
		ValidatorUtils.validateEntity(expressCompanySearch);
        EntityWrapper< ExpressCompanyEntity> ew = new EntityWrapper< ExpressCompanyEntity>();
		ExpressCompanyEntity expressCompany = new  ExpressCompanyEntity( expressCompanySearch);
		ew.setEntity(expressCompany);
		expressCompanyService.selectList(ew);
		return R.ok("查询成功").put("data",expressCompanyService.selectList(ew));
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("获取相应的")
    public R info(@PathVariable("id") Integer id){
        ExpressCompanyEntity expressCompany = expressCompanyService.selectById(id);
        return R.ok().put("expressCompany", expressCompany);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加数据")
    public R saveJson(@RequestBody ExpressCompanyEntity expressCompany){
    	ValidatorUtils.validateEntity(expressCompany);
        expressCompanyService.insert(expressCompany);
        return R.ok();
    }

    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加数据 （参数：表单格式）")
    public R saveForm(ExpressCompanyEntity expressCompany){
    	ValidatorUtils.validateEntity(expressCompany);
        expressCompanyService.insert(expressCompany);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update")
    @ApiOperation("修改数据（参数：json格式）")
    public R updateJson(@RequestBody ExpressCompanyEntity expressCompany){
        ValidatorUtils.validateEntity(expressCompany);
        expressCompanyService.updateAllColumnById(expressCompany);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改数据（参数：表单格式）")
    public R updateForm(ExpressCompanyEntity expressCompany){
        ValidatorUtils.validateEntity(expressCompany);
        expressCompanyService.updateAllColumnById(expressCompany);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除数据")
    public R delete(@RequestBody Integer[] ids){
        expressCompanyService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
