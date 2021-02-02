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

package com.freeter.modules.oss.cloud;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
//import org.junit.Test;

import com.freeter.common.exception.RRException;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * 七牛云存储
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-25 15:41
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class QiniuCloudStorageService extends CloudStorageService {
    private UploadManager uploadManager;
    
    public  BucketManager bucketManager;
    private String token;

    public QiniuCloudStorageService(CloudStorageConfig config){
        this.config = config;

        //初始化
        init();
    }

    private void init(){
        uploadManager = new UploadManager(new Configuration(Zone.autoZone()));
        Auth auth = Auth.create(config.getQiniuAccessKey(), config.getQiniuSecretKey());
        token = auth.
                uploadToken(config.getQiniuBucketName());
        bucketManager = new BucketManager(  auth,new Configuration(Zone.autoZone()));
    }

    
    /**   
     * @Title: deleteFile   
     * @Description: TODO(根据文件名删除文件)   
     * @param: @param fileName      
     * @return: void      
     * @throws   
     */  
    @Override
    public void deleteFile(String fileName) {
    	try {
    		 Response res =bucketManager.delete(config.getQiniuBucketName(), fileName);
    		 int status = res.statusCode;
    		 System.out.println(status);
      	} catch (QiniuException e) {
    	// TODO Auto-generated catch block
    		int statusCode = e.response.statusCode;
    		/*
    		 * 待删除资源不存在
    		 */
    		 System.out.println(statusCode);
    		if(statusCode == 612) {
    			
     		}
 		}
     }
    
 
    
    
    /**   
     * @Title: deleteByPath   
     * @Description: TODO(根据文件完整路径删除文件)   
     * @param: @param filePath      
     * @return: void      
     * @throws   
     */  
    @Override
    public void deleteByPath(String filePath) {
    		 String domain = config.getQiniuDomain();
    		 String fileName =filePath.substring(domain.length()+1); 
    		 deleteFile(fileName);
     }
    
    @Override
    public String upload(byte[] data, String path) {
        try {
              Response res = uploadManager.put(data, path, token);
            if (!res.isOK()) {
                throw new RuntimeException("上传七牛出错：" + res.toString());
            }
        } catch (Exception e) {
            throw new RRException("上传文件失败，请核对七牛配置信息", e);
        }

        return config.getQiniuDomain() + "/" + path;
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return this.upload(data, path);
        } catch (IOException e) {
            throw new RRException("上传文件失败", e);
        }
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, getPath(config.getQiniuPrefix(), suffix));
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, getPath(config.getQiniuPrefix(), suffix));
    }
}
