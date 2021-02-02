package com.hoo.codegenerator.server.core.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目属性
 *
 * @author hank
 * @create 2019-10-15 上午11:11
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectMetadata {
    private String group;
    private String artifact;
    /**
     * type & language & packaging * java Version
     */
    private String version;
    private String name;
    private String description;
    private String packageName;

}
