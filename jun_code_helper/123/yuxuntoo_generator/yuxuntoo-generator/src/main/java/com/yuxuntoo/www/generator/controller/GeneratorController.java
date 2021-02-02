package com.yuxuntoo.www.generator.controller;

import com.yuxuntoo.www.common.exception.BussException;
import com.yuxuntoo.www.generator.service.GeneratorService;
import com.yuxuntoo.www.common.vo.req.QueryParamReq;
import com.yuxuntoo.www.common.vo.resp.ApiResult;
import com.yuxuntoo.www.common.vo.resp.PageInfo;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 代码生成器
 * 
 * @author Camel
 */
@Controller
@RequestMapping("/sys/generator")
public class GeneratorController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private GeneratorService sysGeneratorService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public ApiResult list(@RequestParam Map<String, Object> params){
		ApiResult apiResult = new ApiResult();
		PageInfo pageInfo = sysGeneratorService.queryList(new QueryParamReq(params));
		apiResult.getData().put("page", pageInfo);
		return apiResult;
	}
	
	/**
	 * 生成代码
	 */
	@RequestMapping("/code")
	public void code(String tables, HttpServletResponse response) throws IOException, BussException {
		logger.info("【选中表名为】：{}",tables);
		byte[] data = sysGeneratorService.generatorCode(tables.split(","));
		
		response.reset();  
        response.setHeader("Content-Disposition", "attachment; filename=\"yuxuntoo.zip\"");
        response.addHeader("Content-Length", "" + data.length);  
        response.setContentType("application/octet-stream; charset=UTF-8");  
  
        IOUtils.write(data, response.getOutputStream());  
	}
}
