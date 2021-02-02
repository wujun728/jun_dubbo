package com.hoo.codegenerator.server.core.api;

import com.hoo.codegenerator.server.common.model.Res;
import com.hoo.codegenerator.server.core.service.TplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

/**
 * 模版控制器
 *
 * @author hank
 * @create 2020-12-29 下午2:30
 **/
@RestController
@RequestMapping("api/tpl")
public class TplController {

    @Autowired TplService tplService;

    @RequestMapping("all")
    public Res all(){
        return Res.data(tplService.queryAll());
    }

}
