package io.renren;

import java.io.File;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.system.SystemUtil;

public class MuluTest {

	public static void main(String[] args) {
		SystemUtil.dumpSystemInfo();
		
		System.out.println(SystemUtil.get(SystemUtil.USER_DIR));
		System.out.println(SystemUtil.get(SystemUtil.USER_HOME));
		System.out.println(SystemUtil.get(SystemUtil.USER_NAME));
		System.out.println(RandomUtil.randomString("abcdefg",3));
	 
		//FileUtil.createTempFile(new File("D:\\test\\1.txt"));
	 FileUtil.file("D:\\test\\1.txt");
	}

}
