package com.freeter.modules.good.controller;

import java.math.BigDecimal;
import java.util.*;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;
import com.freeter.modules.good.entity.view.GoodSpecPriceSearch;
import com.freeter.modules.good.entity.view.GoodSpecPriceView;
import com.freeter.modules.good.service.GoodSpecPriceService;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;


/**
 * 规格价格表
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-24 14:04:18
 */
@RestController
@RequestMapping("goodspecprice")
@Api(tags="规格价格表接口")
public class GoodSpecPriceController {
    @Autowired
    private GoodSpecPriceService goodSpecPriceService;


    /**
     * 获取商品的价格区间
     */
    @GetMapping("/getPriceInterval")
    @ApiOperation("商品价格区间")
    public R getPriceInterval(Integer goodId){
        EntityWrapper<GoodSpecPriceEntity> entityWrapper=new EntityWrapper<GoodSpecPriceEntity>();
        Wrapper<GoodSpecPriceEntity> wrapper=entityWrapper.eq("good_id",goodId);
        List<GoodSpecPriceEntity> list=goodSpecPriceService.selectList(wrapper);
        List<BigDecimal> priceList=new ArrayList<BigDecimal>();
        Iterator it=list.iterator();
        while (it.hasNext()){
            GoodSpecPriceEntity specPriceEntity= (GoodSpecPriceEntity)it.next();
            priceList.add(specPriceEntity.getPrice());
        }
        priceList.sort(new Comparator<BigDecimal>() {
            public int compare(BigDecimal o1, BigDecimal o2) {
                return o1.compareTo(o2);
            }
        });
        BigDecimal minPrice=priceList.get(0);
        BigDecimal maxPrice=priceList.get(priceList.size()-1);

        return R.ok().put("maxPrice",maxPrice).put("minPrice",minPrice);
    }


    /**
     * 根据商品id获取规格价格列表
     * @Param 商品id
     */
    @GetMapping("selectListByGoodId")
    @ApiOperation("商品id获取规格价格列表")
    public R getSpecPriceListByGoodId(Integer goodId){
        EntityWrapper<GoodSpecPriceEntity> entityWrapper=new EntityWrapper<GoodSpecPriceEntity>();
        Wrapper<GoodSpecPriceEntity> wrapper=entityWrapper.eq("good_id",goodId);
        List<GoodSpecPriceEntity> list=goodSpecPriceService.selectList(wrapper);
        return R.ok().put("data",list);
    }


    /**
     * 根据商品id以及规格查询价格
     * @Param Map map
     * goodId+Json字符串
     */
    @GetMapping("getPriceBySpec")
    @ApiOperation("查看商品价格@param goodId：商品id，specStr：规格str")
    public R getPriceBySpec(HttpServletRequest request){
        String goodId=request.getParameter("goodId");
        String specStr=request.getParameter("specStr");
        EntityWrapper<GoodSpecPriceEntity> entityWrapper=new EntityWrapper<GoodSpecPriceEntity>();
        Wrapper<GoodSpecPriceEntity> wrapper=entityWrapper.eq("good_id",goodId).and().eq("spec",specStr);
        GoodSpecPriceEntity goodSpecPriceEntity=goodSpecPriceService.selectOne(wrapper);
        BigDecimal price=goodSpecPriceEntity.getPrice();
        return R.ok().put("data",price);
    }

}
