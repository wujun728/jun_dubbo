package ${conf.basePackage}.${table.lowerCamelName}.dto;

<#list table.columns as col>
<#if (col.classImport != "")>
import ${col.classImport};
</#if>
</#list>
import ${conf.basePackage}.doc.annotation.InitField;
import ${conf.basePackage}.validate.AnnotationValidable;
import lombok.Data;

import java.io.Serializable;

/**
 * ${table.comment} 分页 ReqDTO
 *
 * @author ${conf.author}
 * @version ${conf.version}
 * @since ${conf.createDate}
 */
@Data
public class ${table.className}PageReqDTO implements AnnotationValidable, Serializable {

    private static final long serialVersionUID = 5409185459234711691L;

    <#list table.columns as col>
    /**
     * ${col.comment}
     */
    @InitField(value = "", desc = "${col.comment}")
    private ${col.javaType} ${col.camelName};

    </#list>
}
