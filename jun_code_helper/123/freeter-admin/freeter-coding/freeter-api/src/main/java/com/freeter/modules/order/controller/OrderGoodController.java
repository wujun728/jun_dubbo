package com.freeter.modules.order.controller;

import java.util.Arrays;
import java.util.Map;

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
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.order.entity.OrderGoodEntity;
import com.freeter.modules.order.entity.view.OrderGoodSearch;
import com.freeter.modules.order.entity.view.OrderGoodView;
import com.freeter.modules.order.service.OrderGoodService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**order
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 17:20:46
 */
@RestController
@RequestMapping("ordergood")
@Api(tags="订单商品接口")
public class OrderGoodController {
    @Autowired
    private OrderGoodService orderGoodService;

}
