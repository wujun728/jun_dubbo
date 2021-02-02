package io.renren;


import java.sql.SQLException;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.freeter.modules.sys.entity.SysUserEntity;

import io.renren.service.DataSourceTestService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDataSourceTest {
    @Autowired
    private DataSourceTestService dataSourceTestService;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
    @Test
    public void test(){
        //数据源1
        SysUserEntity user1 = dataSourceTestService.queryUser(1L);
        System.out.println(ToStringBuilder.reflectionToString(user1));

        //数据源2
        SysUserEntity user2 = dataSourceTestService.queryUser2(1L);
        System.out.println(ToStringBuilder.reflectionToString(user2));

        //数据源1
        SysUserEntity user3 = dataSourceTestService.queryUser(1L);
        System.out.println(ToStringBuilder.reflectionToString(user3));
    }
    
    @Test
    public void test2() {
    	try {
			System.out.println(sqlSessionTemplate.getSqlSessionFactory().openSession().getConnection().getMetaData().getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	sqlSessionTemplate.getSqlSessionFactory().openSession().selectOne("com.cnadmart.modules.sys.dao.MobileDao.selectById", 1);
	     System.out.println(1);
    }
    
    

}
