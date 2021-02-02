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

package com.freeter.common.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.freeter.common.annotation.J2CacheEvit;

import net.oschina.j2cache.CacheChannel;

/**
 * 如果手动创建缓存，请使用这个注解来删除缓存
 *
 * @author xc 171998110@qq.com
 * @since   2018-06-29
 */
@Aspect
@Component
public class J2CacheEvitAspect {
	@Autowired
	private CacheChannel cacheChannel;
	
	@Pointcut("@annotation(com.freeter.common.annotation.J2CacheEvit)")
	public void J2CacheEvitPointCut() { 
		
	}

	@Around("J2CacheEvitPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		// 执行方法
		Object result = point.proceed();
		J2CacheEvit(point);
		return result;
	}

	private void J2CacheEvit(ProceedingJoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		J2CacheEvit j2CacheEvit = method.getAnnotation(J2CacheEvit.class);
		cacheChannel.clear(j2CacheEvit.value());
	}
}
