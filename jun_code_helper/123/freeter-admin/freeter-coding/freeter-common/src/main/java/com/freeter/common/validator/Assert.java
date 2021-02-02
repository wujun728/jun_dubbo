/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.freeter.common.validator;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;

import com.freeter.common.exception.RRException;

import cn.hutool.core.bean.BeanUtil;

/**
 * 数据校验
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:50
 */
public abstract class Assert {

	public static void isBlank(String str, String message) {
		if (StringUtils.isBlank(str)) {
			throw new RRException(message);
		}
	}

	public static void isNull(Object object, String message) {
		if (object == null) {
			throw new RRException(message);
		}
	}

	public static void notEmpty(Object t) {
		try {
			org.springframework.util.Assert.notEmpty(BeanUtil.beanToMap(t, false, true), "数据不能都为空");

		} catch (Exception e) {
			// TODO: handle exception
			throw new RRException(e.getMessage());

		}
	}

}
