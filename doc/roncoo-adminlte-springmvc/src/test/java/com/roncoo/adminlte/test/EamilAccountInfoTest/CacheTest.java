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
package com.roncoo.adminlte.test.EamilAccountInfoTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.roncoo.adminlte.bean.entity.RcEmailAccountInfo;
import com.roncoo.adminlte.cache.EmailAccountInfoCache;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-core.xml")
public class CacheTest {
	
	
	@Autowired
	private EmailAccountInfoCache emailAcountInfoCache;
	
	@Test
	public void testCache(){
		System.out.println(emailAcountInfoCache);
		emailAcountInfoCache.init();
		List<RcEmailAccountInfo> result = emailAcountInfoCache.getList();
		for (RcEmailAccountInfo rcEmailAccountInfo : result) {
			System.out.println(rcEmailAccountInfo.toString());
		}
	}
}
