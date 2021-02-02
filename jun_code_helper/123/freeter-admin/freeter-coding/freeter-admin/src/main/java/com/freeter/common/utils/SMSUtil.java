package com.freeter.common.utils;

import com.shcm.bean.SendResultBean;
import com.shcm.send.DataApi;
import com.shcm.send.OpenApi;

import java.util.List;

/**
 * @description (描述)短信相关操作
 * @project hzcm
 * @package common.tools
 * @file_name SMSUtil.java
 * @copyright CopyRight (C) 2015 HZCM All Rights Reserved
 * @version 1.0 
 * @date 2015年8月27日 上午11:12:15
 * @author sheng
 */
public class SMSUtil
{
	private static String sOpenUrl = "http://smsapi.c123.cn/OpenPlatform/OpenApi";
	private static String sDataUrl = "http://smsapi.c123.cn/DataPlatform/DataApi";
	
	// 接口帐号
	private static final String account = "1001@501231780001";
	
	// 接口密钥
	private static final String authkey = "B718B0301248589E5244276DB1506EB5";
	
	// 通道组编号
	private static final int cgid = 5755;
	
	// 默认使用的签名编号(未指定签名编号时传此值到服务器)
	private static final int csid = 0;
	
	/**
	 * @description (描述)发送短信
	 * @date 2015年8月27日 上午11:12:04
	 * @author sheng
	 * @param phone 手机号码
	 * @param content 短信内容
	 * @param isreply 是否回复
	 * @return
	 */
	public static String[] sendSMS(String phone, String content, String isreply)
	{
		System.out.println("发送短信：开始=========================================================>>>>>");
		System.out.println("发送短信：手机号码《《"+phone+"》》；短信内容《《"+content+"》》；是否回复《《"+isreply+"》》");
		String[] returnMess = new String[2];
		
		
		if("13926908659".equals(phone))
		{
			returnMess[0]="1";returnMess[1]="发送屏蔽";
		}
		else
		{
			OpenApi.initialzeAccount(sOpenUrl, account, authkey, cgid, csid);
			
			
			DataApi.initialzeAccount(sDataUrl, account, authkey);
			
			List<SendResultBean> listItem = OpenApi.sendOnce(phone, content, 0, 0, null);
			
			if(listItem != null)
			{
				for(SendResultBean t:listItem)
				{
					if(t.getResult() < 1)
					{
						System.out.println("发送提交失败: " + t.getErrMsg());
						returnMess[0]="-1";returnMess[1]="发送失败";
					}
					
					System.out.println("发送成功: 消息编号<" + t.getMsgId() + "> 总数<" + t.getTotal() + "> 余额<" + t.getRemain() + ">");
					returnMess[0]="1";returnMess[1]="发送成功";
				}
			}
		}
		//returnMess[0]="-1";returnMess[1]="发送失败";	
		System.out.println("发送短信：发送状态《《"+returnMess[0]+"》》；返回内容《《"+returnMess[1]+"》》");
		System.out.println("发送短信：结束=========================================================>>>>>");
		System.out.println();
		return returnMess;
	}
	
	public static void main(String[] args)
	{
		sendSMS("18356087258", "注册成功", "0");
	}
}
