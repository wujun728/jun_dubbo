/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.adminlte.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.adminlte.bean.entity.RcEmailInfo;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.biz.EmailInfoBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.PageBean;

/**
 * email功能
 * 
 * @author LYQ
 */
@Controller
@RequestMapping(value = "/admin/emailInfo", method = RequestMethod.POST)
public class EmailInfoController extends BaseController {

	@Autowired
	private EmailInfoBiz biz;

	/**
	 * 分页查询
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param modelMap
	 */
	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "20") int pageSize, ModelMap modelMap) {
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public void add(ModelMap modelMap) {
	}

	@ResponseBody
	@RequestMapping(value = PAGE)
	public PageBean<RcEmailInfo> queryForList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize,@RequestParam(value="date",required=false)String  date,@RequestParam(value="search",required=false)String search) {
		int pageCurrent = (start/pageSize)+1;
		Result<Page<RcEmailInfo>> result = biz.listForPage(pageCurrent, pageSize,search,date);
		return new PageBean<RcEmailInfo>(result.getResultData());
	}

	/**
	 * 发送邮件
	 * 
	 * @param infoVo
	 * @return
	 */
	@RequestMapping(value = "/send")
	public String send(@ModelAttribute RcEmailInfo rcEmailInfo) {
		Result<RcEmailInfo> result = biz.sendMail(rcEmailInfo);
		if(result.isStatus()){
			return redirect("/admin/emailInfo/list");
		}
		return "admin/emailInfo/list";

	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id") Long id) {
		Result<RcEmailInfo> result = biz.delete(id);
		if(result.isStatus()){
			return redirect("/admin/emailInfo/list");
		}
		return "admin/emailInfo/list";
	}

	/**
	 * 查看
	 * 
	 * @param id
	 */
	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(@RequestParam(value = "id") Long id, ModelMap modelMap) {
		Result<RcEmailInfo> result = biz.query(id);
		if(result.isStatus()){
			modelMap.put("info", result.getResultData());
		}
	}
}
