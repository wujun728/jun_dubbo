package com.freeter.modules.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.R;
import com.freeter.modules.category.entity.CategoryEntity;
import com.freeter.modules.category.entity.view.CategoryModel;
import com.freeter.modules.category.entity.view.CategorySearch;
import com.freeter.modules.category.entity.view.CategoryView;
import com.freeter.modules.category.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * 分类表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-21 17:07:26
 */
@RestController
@RequestMapping("category")
@Api(tags="分类表接口")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
  /*  @GetMapping("/list")
    @ApiOperation("获取品牌")
    public R list(){
        EntityWrapper< CategoryEntity> ew = new EntityWrapper< CategoryEntity>();
 		CategoryEntity category = new  CategoryEntity();
 		ew.setEntity(category);
 		category.setStatus(1);
 		ew.orderBy("sort");
 		category.setType(0);
 		return R.ok("查询分类表成功").put("data",categoryService.selectList(ew));
    }*/

    /**
     * 查询
     */
    @GetMapping("/search")
    @ApiOperation("查询分类、热门、导航分类表")
    public R search(CategorySearch categorySearch){
        EntityWrapper< CategoryEntity> ew = new EntityWrapper< CategoryEntity>();
		CategoryEntity category = new  CategoryEntity( categorySearch);
		ew.setEntity(category);
		category.setStatus(1);
		ew.orderBy("sort");
		category.setType(1);
		return R.ok("查询分类表成功").put("data",categoryService.selectList(ew));
    }

    /**
     * 分类列表
     */
    @GetMapping("list")
    @ApiOperation("分类列表")
    public R goodCategory(CategorySearch categorySearch ){
        EntityWrapper<CategoryEntity> categoryEntityWrapper=new EntityWrapper<CategoryEntity>();
        CategoryEntity categoryEntity=new CategoryEntity(categorySearch);
        categoryEntityWrapper.setEntity(categoryEntity);
        List<CategoryEntity> categoryEntityList=categoryService.selectList(categoryEntityWrapper);
        List<CategoryView> categoryViewList=new ArrayList<>();
        Iterator categoryEntityListIt=categoryEntityList.iterator();
        List<CategoryModel> categoryModelList=new ArrayList<CategoryModel>();
        while(categoryEntityListIt.hasNext()){
            CategoryView categoryView=new CategoryView();
            CategoryEntity category=(CategoryEntity) categoryEntityListIt.next();
            categoryView.setCategoryId(category.getCategoryId());
            categoryView.setCategoryName(category.getName());
            Map seoMsgMap=new HashMap();
            seoMsgMap.put("title",category.getPageTitle());
            seoMsgMap.put("description",category.getPageDescription());
            seoMsgMap.put("keyword",category.getPageKeyword());
            categoryView.setSeoMsg(seoMsgMap);
            CategoryModel categoryModel=new CategoryModel();
            categoryModel.setFirstCategory(categoryView);
            //二级分类
            List<CategoryView> secondCategoryViewList=new ArrayList<CategoryView>();
            EntityWrapper<CategoryEntity> secondCategoryEntityWrapper=new EntityWrapper<CategoryEntity>();
            System.out.println(categoryEntity.getCategoryId());
            List<CategoryEntity> secondCategoryEntityList=categoryService.selectList(secondCategoryEntityWrapper.eq("parent_id",category.getCategoryId()));
            if(secondCategoryEntityList.size()==0){
                categoryModel.setSecondCategory(null);
                categoryModelList.add(categoryModel);
            }else{
                Iterator secondCategoryEntityListIt=secondCategoryEntityList.iterator();
                while(secondCategoryEntityListIt.hasNext()){
                    CategoryEntity secondCategoryEntity=(CategoryEntity) secondCategoryEntityListIt.next();
                    CategoryView secondCategoryView=new CategoryView();
                    secondCategoryView.setCategoryId(secondCategoryEntity.getCategoryId());
                    secondCategoryView.setCategoryName(secondCategoryEntity.getName());
                    Map secondSeoMsgMap=new HashMap();
                    secondSeoMsgMap.put("title",secondCategoryEntity.getPageTitle());
                    secondSeoMsgMap.put("description",secondCategoryEntity.getPageDescription());
                    secondSeoMsgMap.put("keyword",secondCategoryEntity.getPageKeyword());
                    secondCategoryView.setSeoMsg(secondSeoMsgMap);
                    secondCategoryViewList.add(secondCategoryView);
                    categoryModel.setSecondCategory(secondCategoryViewList);
                }
            }
            categoryModelList.add(categoryModel);
        }


        return R.ok().put("data",categoryModelList);

    }

}
