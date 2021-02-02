package com.freeter.common.utils;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.util.StringUtils;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;
import com.freeter.modules.good.entity.GoodSpecValueEntity;

import cn.hutool.core.bean.BeanUtil;

public class SpecUtil {

	public static List<List<GoodSpecValueEntity>>  getTypeGoodSpecValueList(List<GoodSpecValueEntity> goodSpecValueList){
		  List<GoodSpecValueEntity> cpGoodSpecValueList = new ArrayList();
          cpGoodSpecValueList.addAll(goodSpecValueList);
          List<List<GoodSpecValueEntity>>  listType =  SpecUtil.getTypeGoodSpecValueList(cpGoodSpecValueList, new ArrayList());
		return listType;
	}
	
	public static List<GoodSpecPriceEntity> getGoodSpecPriceList(List<List<GoodSpecValueEntity>> listType){
	      
        GoodSpecPriceEntity goodSpecPriceEntity = new GoodSpecPriceEntity();
        goodSpecPriceEntity.setGoodId( listType.get(0).get(0).getGoodId());
        List<GoodSpecPriceEntity> listGoodSpecPrice = new ArrayList();
        listGoodSpecPrice.add(goodSpecPriceEntity);
        listGoodSpecPrice = SpecUtil.getGoodSpecPriceListByGoodSpecPrice(listType, listGoodSpecPrice);
		return listGoodSpecPrice;
	}
	
	
	
	public static List<GoodSpecValueEntity> getGoodSpecValueListByEQCategorySpecId(GoodSpecValueEntity e,
			List<GoodSpecValueEntity> list) {
		List<GoodSpecValueEntity> listR = new ArrayList();

		Integer categorySpecId = e.getCategorySpecId();
		GoodSpecValueEntity en = null;
		for (GoodSpecValueEntity goodSpecValueEntity : list) {

			// 找到相同的规格的  类返回新的集合
			if (goodSpecValueEntity.getCategorySpecId().equals(categorySpecId)) {
				listR.add(goodSpecValueEntity);
			}

		}
		return listR;
	}

	/*
	 * 把 商品中的所有规格 按照 不同规格 划分不同的集合
	 * 
	 * 把相同的商品规格的实体类放在一起
	 */
	public static  List<List<GoodSpecValueEntity>> getTypeGoodSpecValueList(List<GoodSpecValueEntity> list,
			List<List<GoodSpecValueEntity>> listByType) {

 		if (list.isEmpty()) {
			return listByType;
		}
		
		GoodSpecValueEntity gsve = list.get(0);

		
		// 找到相同的分类规格的实体类返回新的集合
		List<GoodSpecValueEntity> gsvList = getGoodSpecValueListByEQCategorySpecId(gsve, list);

		// 添加新的集合
		listByType.add(gsvList);
		// 删掉旧的集合
		list.removeAll(gsvList);

		if (list.isEmpty()) {
			return listByType;
		}
		getTypeGoodSpecValueList(list, listByType);

		return listByType;
	}

	/*
	 * 颜色： 红白蓝
	 * 大小： 大 中 小
	 * 
	 * 结果 红大 红中 红小 白大 ...
	 * 
	 */
	public static List<GoodSpecPriceEntity> getGoodSpecPriceListByGoodSpecPrice(List<List<GoodSpecValueEntity>> listType,
			List<GoodSpecPriceEntity> listGoodSpecPrice) {

		List<GoodSpecPriceEntity> resultList = new ArrayList();
		if (listType.isEmpty()) {
			return resultList;
		}
		if (listGoodSpecPrice.isEmpty()) {
			return resultList;
		}

		
		listGoodSpecPrice: for (int j = 0; j < listGoodSpecPrice.size(); j++) {

			for (int i = 0; i < listType.size(); i++) {

				GoodSpecPriceEntity gspe = listGoodSpecPrice.get(j);
				String sp = gspe.getSpec();
				String spname = gspe.getSpecName();
				if (sp == null) {
					sp = "";
					spname = "";
				}
				if (!StringUtils.isEmpty(sp)) {
					sp += ",";
					spname += ",";
				}

				List<GoodSpecValueEntity> l = listType.get(i);
				for (GoodSpecValueEntity gsve : l) {
					GoodSpecPriceEntity gspeEn = new GoodSpecPriceEntity();
					Integer c = gsve.getId();
					String value = gsve.getSpecValue();
					BeanUtil.copyProperties(gspe, gspeEn);
					gspeEn.setSpec(sp + c);
					gspeEn.setSpecName(spname+value);
					resultList.add(gspeEn);

				}

				if (j < listGoodSpecPrice.size() - 1) {
					continue listGoodSpecPrice;
				} else {
					listGoodSpecPrice.clear();
					listType.remove(0);

				}
				if (listType.isEmpty() || listType == null) {
					return resultList;
				}
				return getGoodSpecPriceListByGoodSpecPrice(listType, resultList);
			}

		}
		return getGoodSpecPriceListByGoodSpecPrice(listType, resultList);

	}

}
