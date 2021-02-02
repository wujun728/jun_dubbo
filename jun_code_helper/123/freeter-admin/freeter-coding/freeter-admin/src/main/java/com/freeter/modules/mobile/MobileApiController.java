package com.freeter.modules.mobile;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.sys.entity.MobileEntity;
import com.freeter.modules.sys.service.MobileService;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-23 13:57:13
 */
@RestController
@RequestMapping("/mobile")
public class MobileApiController {
    @Autowired
    private MobileService mobileService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:mobile:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mobileService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:mobile:info")
    public R info(@PathVariable("id") Long id){
        MobileEntity mobile = mobileService.selectById(id);
         return R.ok().put("mobile", mobile);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
  /*  @RequiresPermissions("sys:mobile:save")*/
    public R save(@RequestBody MobileEntity mobile){
    	  ValidatorUtils.validateEntity(mobile);
    	mobileService.insert(mobile);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:mobile:update")
    public R update(@RequestBody MobileEntity mobile){
        ValidatorUtils.validateEntity(mobile);
        mobileService.updateAllColumnById(mobile);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:mobile:delete")
    public R delete(@RequestBody Long[] ids){
        mobileService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
