package com.freeter.modules.sys;

/*import org.junit.Test;
import org.junit.runner.RunWith;*/
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;*/

 
public class Test1 {


    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
	
	//  @Test
	  public void test2() {
		  System.err.println(1);
		/*  sqlSessionTemplate.getSqlSessionFactory().openSession().selectOne("io.renren.modules.sys.dao.MobileDao.selectById", 1);
	     	System.out.println("databaseId: "+ sqlSessionTemplate.getConfiguration().getDatabaseId());
	 */   }
	
}
