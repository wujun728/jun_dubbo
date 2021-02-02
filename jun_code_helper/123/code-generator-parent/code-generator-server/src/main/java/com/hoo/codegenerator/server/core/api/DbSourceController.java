package com.hoo.codegenerator.server.core.api;

import com.baomidou.mybatisplus.extension.api.R;
import com.hoo.codegenerator.server.common.model.Res;
import com.hoo.codegenerator.server.core.bean.entity.DbSource;
import com.hoo.codegenerator.server.core.service.IDbSourceService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.relation.RoleUnresolved;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据源 控制器
 *
 * @author hank
 * @create 2020-12-31 上午10:35
 **/
@RestController
@RequestMapping("api/dbsource")
public class DbSourceController {
    @Resource
    private IDbSourceService service;

    @GetMapping("/all")
    public Res queryAll(String searchWord, String dbType) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("searchWord", searchWord);
        params.put("dbType", dbType);
        return Res.data(service.findAll(params));
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public Res insert(DbSource entity){
        return Res.data(service.add(entity));
    }

    /**
     * 更新
     */
    @PutMapping("/update")
    public Res update(DbSource entity){
        return Res.data(service.update(entity));
    }

    /**
     * 刪除
     */
    @DeleteMapping("/delete/{ids}")
    public Res delete(@PathVariable("ids") String ids) {
        if (StringUtils.isEmpty(ids)) {
            throw new RuntimeException("参数不合法");
        }
        List<Long> list = new ArrayList<Long>();
        for (String id : ids.split(",")) {
            list.add(Long.valueOf(id));
        }
        return Res.data(service.batchDelete(list));
    }

}
