package com.hoo.codegenerator.server.core.bean.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 模版DTO
 *
 * @author hank
 * @create 2020-12-29 上午10:25
 **/
@Data
public class TplDto implements Serializable {
    private String title;
    private String content;
    private String suffix;
    private Long tplId;
    private Long groupId;
    private String groupName;
}
