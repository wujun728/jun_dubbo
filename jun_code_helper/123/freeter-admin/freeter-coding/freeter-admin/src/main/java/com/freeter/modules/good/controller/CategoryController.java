package com.freeter.modules.good.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.JQPageInfo;
import com.freeter.common.utils.PageInfo;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.Assert;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.CategoryEntity;
import com.freeter.modules.good.entity.view.CategoryView;
import com.freeter.modules.good.service.CategoryService;
import com.freeter.modules.oss.cloud.OSSFactory;



/**
 * 分类表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
@RestController
@RequestMapping("good/category")
@SuppressWarnings("rawtypes")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("good:category:list")
    public R list(JQPageInfo pageInfo){
      
		PageUtils page = categoryService.queryPage(new PageInfo(pageInfo));
        return R.ok().put("page", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/getCategorylist")
    @RequiresPermissions("good:category:list")
    public R getCategorylist(){
    	 
        CategoryEntity categoryEntity = new CategoryEntity();
    	EntityWrapper< CategoryEntity> ew = new EntityWrapper< CategoryEntity>();
    	ew.orderBy("sort", true);
        List page = categoryService.selectListVO(ew);
        CategoryView v = new CategoryView();
        v.setParentId(-1l);
        v.setCategoryId(0L);
        v.setName("一级分类");
        v.setStatus(1);
        page.add(0, v);
        return R.ok().put("data", page);
     }
    

    /**
     * 列表
     */
    @RequestMapping("/getOneCategorylist")
    @RequiresPermissions("good:category:list")
    public R getOneCategorylist(CategoryEntity categoryEntity){
    	 
        
    	EntityWrapper< CategoryEntity> ew = new EntityWrapper< CategoryEntity>();
    	ew.setEntity(categoryEntity);
    	ew.orderBy("sort", true);
        List page = categoryService.selectList(ew);
         
        return R.ok().put("data", page);
     }
    
    /**
     * 列表
     */
    @RequestMapping("/getCategoryTreeTable")
    @RequiresPermissions("good:category:list")
    public List getCategoryTreeTable(CategoryEntity categoryEntity){
     	EntityWrapper< CategoryEntity> ew = new EntityWrapper< CategoryEntity>();
      	ew.eq(StringUtils.isNotBlank(categoryEntity.getChannelId()),"channel_id",categoryEntity.getChannelId());
      	ew.like("name", categoryEntity.getName());
     	ew.orderBy("sort is null,sort ", true);
     	List<CategoryView> page = categoryService.selectListView(ew);
      /*  if(page.size() >0) {
        	if(page.get(0).getCategoryId() == 0)
        		page.remove(0);
        }
         */
        return page;
     }
    
    /**
     * 列表
     */
    @RequestMapping("/getCategoryTreeTabletest")
    @RequiresPermissions("good:category:list")
    public List getCategoryTreeTabletest(){
    	 
        CategoryEntity categoryEntity = new CategoryEntity();
    	EntityWrapper< CategoryEntity> ew = new EntityWrapper< CategoryEntity>();
    	ew.orderBy("sort", true);
        List page = categoryService.selectListView(ew);
        CategoryView v = new CategoryView();
        v.setParentId(-1l);
        v.setCategoryId(0L);
        v.setName("一级分类");
        v.setStatus(1);
        page.set(0, v);
         
        return page;
     }
    
    /**
     * 信息
     */
    @RequestMapping("/info/{categoryId}")
    @RequiresPermissions("good:category:info")
    public R info(@PathVariable("categoryId") Long categoryId){
        CategoryEntity category = categoryService.selectById(categoryId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("good:category:save")
    public R save(@RequestBody CategoryEntity category){
    	ValidatorUtils.validateEntity(category);
        categoryService.insert(category);
          return R.ok();
    }
    
    /**
     * 修改
     * @throws Exception 
     */
    @RequestMapping("/uploadIcon")
    @RequiresPermissions("good:category:update")
    public R uploadIcon(CategoryEntity category, @RequestParam("files") MultipartFile file) throws Exception{
    	if (file != null && file.getSize() > 0) {

			// 上传文件
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);
			category.setIcon(url);
		}
    	categoryService.updateById(category);
        
        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/deleteIcon")
    @RequiresPermissions("good:category:update")
    public R deleteIcon(CategoryEntity category, @RequestParam(value = "filePath") String filePath){
    	OSSFactory.build().deleteByPath(filePath);
		 
     	CategoryEntity  categoryEntity = categoryService.selectById(category.getCategoryId());
     	categoryEntity.setIcon(null);
        categoryService.updateAllColumnById(categoryEntity);//全部更新
        
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("good:category:update")
    public R update(@RequestBody CategoryEntity category){
        ValidatorUtils.validateEntity(category);
        CategoryEntity  categoryEntity = categoryService.selectById(category.getCategoryId());
        category.setIcon(categoryEntity.getIcon());
        categoryService.updateAllColumnById(category);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deletes")
    @RequiresPermissions("good:category:delete")
    public R deletes(@RequestBody Long[] categoryIds){
        categoryService.deleteBatchIds(Arrays.asList(categoryIds));

        return R.ok();
    }
    
    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("good:category:delete")
    public R delete( Long categoryIds){
    	Assert.isNull(categoryIds,"分类id不能为空");
    	EntityWrapper< CategoryEntity> ew = new EntityWrapper< CategoryEntity>();
    	ew.eq("parent_id", categoryIds);
     	List<CategoryEntity> list = categoryService.selectList(ew);
    	if(list.size()>0) {
    		return R.error("请先删除该分类下的二级分类");
    	}
        categoryService.deleteById(categoryIds);

        return R.ok();
    }

}
