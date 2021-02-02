package com.freeter.modules.order.controller;

import java.util.Arrays;
import java.util.Map;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.order.entity.OrderGoodEntity;
import com.freeter.modules.order.entity.view.OrderGoodSearch;
import com.freeter.modules.order.entity.view.OrderGoodView;
import com.freeter.modules.order.service.OrderGoodService;

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




/**order
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 17:20:46
 */
@RestController
@RequestMapping("ordergood")
@Api(tags="接口")
public class OrderGoodController {
    @Autowired
    private OrderGoodService orderGoodService;
 
	
    /**
     * 查询
     */
    @GetMapping("/search")
    @ApiOperation("查询")
    public R search(OrderGoodSearch orderGoodSearch){
		ValidatorUtils.validateEntity(orderGoodSearch);
        EntityWrapper< OrderGoodEntity> ew = new EntityWrapper< OrderGoodEntity>();
		OrderGoodEntity orderGood = new  OrderGoodEntity( orderGoodSearch);
		ew.setEntity(orderGood);
		orderGoodService.selectList(ew);
		return R.ok("查询成功").put("data",orderGoodService.selectList(ew));
    }

	

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("获取相应的")
    public R info(@PathVariable("id") Integer id){
        OrderGoodEntity orderGood = orderGoodService.selectById(id);

        return R.ok().put("orderGood", orderGood);
    }

    /**
     * 保存
     */
    @PostMapping("/save/json")
    @ApiOperation("添加数据")
    public R saveJson(@RequestBody OrderGoodEntity orderGood){
    	ValidatorUtils.validateEntity(orderGood);
        orderGoodService.insert(orderGood);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加数据 （参数：表单格式）")
    public R saveForm(OrderGoodEntity orderGood){
    	ValidatorUtils.validateEntity(orderGood);
        orderGoodService.insert(orderGood);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改数据（参数：json格式）")
    public R updateJson(@RequestBody OrderGoodEntity orderGood){
        ValidatorUtils.validateEntity(orderGood);
        orderGoodService.updateAllColumnById(orderGood);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改数据（参数：表单格式）")
    public R updateForm(OrderGoodEntity orderGood){
        ValidatorUtils.validateEntity(orderGood);
        orderGoodService.updateAllColumnById(orderGood);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除数据")
    public R delete(@RequestBody Integer[] ids){
        orderGoodService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
