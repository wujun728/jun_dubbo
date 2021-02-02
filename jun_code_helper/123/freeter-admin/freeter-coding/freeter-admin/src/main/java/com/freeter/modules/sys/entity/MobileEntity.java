package com.freeter.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-11 09:03:26
 */
@TableName("tb_mobile")
@ApiModel(value = "tb_mobile")
public class MobileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
		
	@TableId 			
	@ApiModelProperty(value = "",hidden = true)
	private Long id;
	
	/**
	 * 品牌
	 */
			
	@NotBlank (message = "品牌不能为空") 	
	@ApiModelProperty(value = "品牌")
	private String brand;
	
	/**
	 * 型号
	 */
			
	@NotBlank (message = "型号不能为空") 	
	@ApiModelProperty(value = "型号")
	private String version;
	
	/**
	 * 上市月份
	 */
				
	@ApiModelProperty(value = "上市月份")
	private String listedyear;
	
	/**
	 * 
	 */
				
	@ApiModelProperty(value = "")
	private String listingmonth;
	
	/**
	 * 机身颜色
	 */
				
	@ApiModelProperty(value = "机身颜色")
	private String color;
	
	/**
	 * 操作系统
	 */
				
	@ApiModelProperty(value = "操作系统")
	private String operatingSystem;
	
	/**
	 * 屏幕
	 */
				
	@ApiModelProperty(value = "屏幕")
	private String screen;
	
	/**
	 * 机身存储空间
	 */
				
	@ApiModelProperty(value = "机身存储空间")
	private String rom;
	
	/**
	 * 机身的运行内存
	 */
				
	@ApiModelProperty(value = "机身的运行内存")
	private String ram;
	
	/**
	 * 屏幕分辨率
	 */
				
	@ApiModelProperty(value = "屏幕分辨率")
	private String resolvingPower;
	
	/**
	 * 机身重量
	 */
				
	@ApiModelProperty(value = "机身重量")
	private String weight;
	
	/**
	 * 主芯片
	 */
				
	@ApiModelProperty(value = "主芯片")
	private String cpu;
	
	/**
	 * 其他
	 */
				
	@ApiModelProperty(value = "其他")
	private String other;
	
	/**
	 * 描述
	 */
				
	@ApiModelProperty(value = "描述")
	private String described;
	
	/**
	 * 手机
	 */
				
	@ApiModelProperty(value = "手机")
	private String phone;
	
	/**
	 * 姓名
	 */
				
	@ApiModelProperty(value = "姓名")
	private String name;
	
	/**
	 * 像素
	 */
				
	@ApiModelProperty(value = "像素")
	private String backCamera;
	
	/**
	 * 
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "")
	private Date createTime;
	
	/**
	 * 
	 */
				
	@ApiModelProperty(value = "")
	private String buyTime;
	

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * 获取：品牌
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * 设置：型号
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 获取：型号
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * 设置：上市月份
	 */
	public void setListedyear(String listedyear) {
		this.listedyear = listedyear;
	}
	/**
	 * 获取：上市月份
	 */
	public String getListedyear() {
		return listedyear;
	}
	/**
	 * 设置：
	 */
	public void setListingmonth(String listingmonth) {
		this.listingmonth = listingmonth;
	}
	/**
	 * 获取：
	 */
	public String getListingmonth() {
		return listingmonth;
	}
	/**
	 * 设置：机身颜色
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * 获取：机身颜色
	 */
	public String getColor() {
		return color;
	}
	/**
	 * 设置：操作系统
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	/**
	 * 获取：操作系统
	 */
	public String getOperatingSystem() {
		return operatingSystem;
	}
	/**
	 * 设置：屏幕
	 */
	public void setScreen(String screen) {
		this.screen = screen;
	}
	/**
	 * 获取：屏幕
	 */
	public String getScreen() {
		return screen;
	}
	/**
	 * 设置：机身存储空间
	 */
	public void setRom(String rom) {
		this.rom = rom;
	}
	/**
	 * 获取：机身存储空间
	 */
	public String getRom() {
		return rom;
	}
	/**
	 * 设置：机身的运行内存
	 */
	public void setRam(String ram) {
		this.ram = ram;
	}
	/**
	 * 获取：机身的运行内存
	 */
	public String getRam() {
		return ram;
	}
	/**
	 * 设置：屏幕分辨率
	 */
	public void setResolvingPower(String resolvingPower) {
		this.resolvingPower = resolvingPower;
	}
	/**
	 * 获取：屏幕分辨率
	 */
	public String getResolvingPower() {
		return resolvingPower;
	}
	/**
	 * 设置：机身重量
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * 获取：机身重量
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * 设置：主芯片
	 */
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	/**
	 * 获取：主芯片
	 */
	public String getCpu() {
		return cpu;
	}
	/**
	 * 设置：其他
	 */
	public void setOther(String other) {
		this.other = other;
	}
	/**
	 * 获取：其他
	 */
	public String getOther() {
		return other;
	}
	/**
	 * 设置：描述
	 */
	public void setDescribed(String described) {
		this.described = described;
	}
	/**
	 * 获取：描述
	 */
	public String getDescribed() {
		return described;
	}
	/**
	 * 设置：手机
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：像素
	 */
	public void setBackCamera(String backCamera) {
		this.backCamera = backCamera;
	}
	/**
	 * 获取：像素
	 */
	public String getBackCamera() {
		return backCamera;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	/**
	 * 获取：
	 */
	public String getBuyTime() {
		return buyTime;
	}
}
