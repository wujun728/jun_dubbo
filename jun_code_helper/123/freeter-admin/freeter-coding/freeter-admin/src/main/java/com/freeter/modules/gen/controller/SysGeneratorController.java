package com.freeter.modules.gen.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.common.utils.R;
import com.freeter.modules.gen.entity.TableEntity;
import com.freeter.modules.gen.service.SysGeneratorService;
import com.freeter.modules.gen.utils.DocMapFactory;
import com.freeter.modules.gen.utils.FreemarkerUtils;
import com.freeter.modules.gen.utils.GenUtils;

import freemarker.template.Template;

/**
 * 飞特超级代码生成器
 * 
 * @author xc
 * @email 171998110@qq.com
 * @date 2018年06月20日 上午9:12:58
 */
@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController {
	@Autowired
	private SysGeneratorService sysGeneratorService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<TableEntity> list = sysGeneratorService.queryList(query);
		int total = sysGeneratorService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getCurrPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 生成数据库文档代码
	 * @throws Exception 
	 */
	@RequestMapping("/doc")
	public void doc(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map map =DocMapFactory.build();
		
		Template template = FreemarkerUtils.getTemplate("dbTemplate.ftl"); 
		// 根据模板生成文件
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		StringWriter sw = new StringWriter();
 		template.process(map,sw);
 		IOUtils.write(sw.toString(), outputStream, "UTF-8");
 		IOUtils.closeQuietly(sw);
 		IOUtils.closeQuietly(outputStream);
 		byte[] data = outputStream.toByteArray();
		response.reset();  
        response.setHeader("Content-Disposition", "attachment; filename=\"doc.doc\"");  
        response.addHeader("Content-Length", "" + data.length);  
        response.setContentType("application/octet-stream; charset=UTF-8");  
  
        IOUtils.write(data, response.getOutputStream());  
	}
	
	/**
	 * 生成代码
	 */
	@RequestMapping("/code")
	public void code(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String tables = request.getParameter("tables");
		String[] tableNames =tables.split(",");
		
		byte[] data = sysGeneratorService.generatorCode(tableNames);
		
		response.reset();  
        response.setHeader("Content-Disposition", "attachment; filename=\"freeter.zip\"");  
        response.addHeader("Content-Length", "" + data.length);  
        response.setContentType("application/octet-stream; charset=UTF-8");  
  
        IOUtils.write(data, response.getOutputStream());  
        IOUtils.closeQuietly( response.getOutputStream());
	}
	
	/**
	 * 更新全部后端代码
	 */
	@RequestMapping("/allcode")
	@ResponseBody
	public R  allcode(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String tables = request.getParameter("tables");
		String[] tableNames =tables.split(",");
		
		sysGeneratorService.generatorAllCode(tableNames,GenUtils.getTemplates());
		
		return R.ok("后端代码全部更新成功，请刷新IDE");
	}
	
	/**
	 * 更新全部api接口代码
	 */
	@RequestMapping("/genAPI")
	@ResponseBody
	public R  genAPI(HttpServletRequest request, HttpServletResponse response) throws IOException{
 		String tables = request.getParameter("tables");
		String[] tableNames =tables.split(",");

		sysGeneratorService.generatorAllCode(tableNames,GenUtils.getAPITemplates());
		
		return R.ok("移动端接口全部更新成功，请刷新IDE");
	}
	
	/**
	 * 更新controller接口代码
	 */
	@RequestMapping("/genController")
	@ResponseBody
	public R  genController(String tables,HttpServletRequest request, HttpServletResponse response) throws IOException{
		String[] tableNames =tables.split(",");
		sysGeneratorService.generatorAllCode(tableNames,GenUtils.getControllerTemplates());
		
		return R.ok("接口更新成功，请刷新IDE");
	}
	
	/**
	 * 更新vo代码
	 */
	@ResponseBody
	@RequestMapping("/genVO")
	public R genVO(String tables,HttpServletRequest request, HttpServletResponse response) throws IOException{
		String[] tableNames = tables.split(",");
		sysGeneratorService.generatorAllCode(tableNames,GenUtils.getVOTemplates());
		return R.ok("代码更新成功，请刷新IDE");
		 
	}
	
	/**
	 * 更新Entity代码
	 */
	@ResponseBody
	@RequestMapping("/genEntity")
	public R genEntity(String tables,HttpServletRequest request, HttpServletResponse response) throws IOException{
		String[] tableNames =tables.split(",");
	 
		sysGeneratorService.generatorAllCode(tableNames,GenUtils.getEntityTemplates());
		return R.ok("代码更新成功，请刷新IDE");
		 
	}
}
