package com.gf.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
 
/**
 * 将文件打包成ZIP压缩文件
 * @author LanP
 * @since 2012-3-1 15:47
 */
public final class FileToZip {

	static boolean flag = false;
	static File sourceFile = null;
	static FileInputStream fis = null;
	static BufferedInputStream bis = null;
	static FileOutputStream fos = null;
	static ZipOutputStream zos = null;

    private FileToZip() {
		
	}
	
	/**
	 * 将存放在sourceFilePath目录下的源文件,打包成fileName名称的ZIP文件,并存放到zipFilePath。
	 * @param sourceFilePath 待压缩的文件路径
	 * @param zipFilePath	 压缩后存放路径
	 * @param fileName		 压缩后文件的名称
	 * @return flag
	 */
	public static boolean fileToZip(String sourceFilePath,String zipFilePath,String fileName) {
		sourceFile = new File(sourceFilePath);
		
		if(sourceFile.exists() == false) {
			System.out.println(">>>>>> 待压缩的文件目录：" + sourceFilePath + " 不存在. <<<<<<");
		} else {
			try {
				File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
				if(zipFile.exists()) {
					System.out.println(">>>>>> " + zipFilePath + " 目录下存在名字为：" + fileName + ".zip" + " 打包文件. <<<<<<");
				} else {
					File[] sourceFiles = sourceFile.listFiles();
					if(null == sourceFiles || sourceFiles.length < 1) {
						System.out.println(">>>>>> 待压缩的文件目录：" + sourceFilePath + " 里面不存在文件,无需压缩. <<<<<<");
					} else {
						fos = new FileOutputStream(zipFile);
						zos = new ZipOutputStream(new BufferedOutputStream(fos));
						byte[] bufs = new byte[1024*10];
						for(int i=0;i<sourceFiles.length;i++) {

							File f =  new File(sourceFilePath + "/" + sourceFiles[i].getName());
							if (f.isDirectory()) {
								File[] files = f.listFiles();
								for (File file : files) {
									File tempF = new File(f.getPath() + "/" + file.getName());
									if (tempF.isDirectory()) {
										zipfile(sourceFilePath + "/" + sourceFiles[i].getName() + "/" + file.getName(), zipFilePath, sourceFilePath);
									} else {
										// 创建ZIP实体,并添加进压缩包
										ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName() + "/" + file.getName());
										zos.putNextEntry(zipEntry);
										// 读取待压缩的文件并写进压缩包里
										fis = new FileInputStream(file);
										bis = new BufferedInputStream(fis,1024*10);
										int read = 0;
										while((read=bis.read(bufs, 0, 1024*10)) != -1) {
											zos.write(bufs, 0, read);
										}
									}
								}
							} else {

								// 创建ZIP实体,并添加进压缩包
								ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
								zos.putNextEntry(zipEntry);
								// 读取待压缩的文件并写进压缩包里
								fis = new FileInputStream(sourceFiles[i]);
								bis = new BufferedInputStream(fis,1024*10);
								int read = 0;
								while((read=bis.read(bufs, 0, 1024*10)) != -1) {
									zos.write(bufs, 0, read);
								}
							}

						}
						flag = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				// 关闭流
				try {
					if(null != bis) bis.close();
					if(null != zos) zos.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		
		return flag;
	}

	public static void zipfile(String path, String zipFilePath, String sourceFilePath) throws Exception{
		File[] files = new File(path).listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				zipfile(path + "/" + file.getName(), zipFilePath, sourceFilePath);
			} else {

				byte[] bufs = new byte[1024*10];
				// 创建ZIP实体,并添加进压缩包
				String tempPath = path.substring(sourceFilePath.length());
				ZipEntry zipEntry = new ZipEntry( tempPath + "/" + file.getName());
				zos.putNextEntry(zipEntry);
				// 读取待压缩的文件并写进压缩包里
				fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis,1024*10);
				int read = 0;
				while((read=bis.read(bufs, 0, 1024*10)) != -1) {
					zos.write(bufs, 0, read);
				}
			}
		}
	}

	
	/**
	 * 将文件打包成ZIP压缩文件,main方法测试
	 * @param args
	 */
	public static void main(String[] args) {

		String sourceFilePath = "f:/big2/mas4";
		String zipFilePath = "f:/big2/";
		String fileName = "mas4-123" + new Random().nextDouble();
		boolean flag = FileToZip.fileToZip(sourceFilePath, zipFilePath, fileName);
		if(flag) {
			System.out.println(">>>>>> 文件打包成功." + fileName + " <<<<<<");
		} else {
			System.out.println(">>>>>> 文件打包失败. <<<<<<");
		}
	}
}
