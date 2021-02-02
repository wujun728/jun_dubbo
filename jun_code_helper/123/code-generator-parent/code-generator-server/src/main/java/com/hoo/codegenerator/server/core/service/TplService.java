package com.hoo.codegenerator.server.core.service;

import com.hoo.codegenerator.server.core.bean.dto.TplDto;

import java.util.List;

/**
 * 模版服务接口
 *
 * @author hank
 * @create 2020-12-29 上午10:25
 **/

public interface TplService {
    /**
     * 查询所有模版
     * @return
     */
    Object queryAll();

}
