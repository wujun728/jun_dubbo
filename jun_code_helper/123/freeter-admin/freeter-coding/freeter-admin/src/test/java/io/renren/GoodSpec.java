package io.renren;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.druid.util.StringUtils;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;
import com.freeter.modules.good.entity.GoodSpecValueEntity;

import cn.hutool.core.bean.BeanUtil;

public class GoodSpec {

	@Test
	public void gppdSPec() {
		List<GoodSpecValueEntity> list = new ArrayList();
		GoodSpecValueEntity gsv1 = new GoodSpecValueEntity();
		gsv1.setId(1);
		gsv1.setCategorySpecId(1);
		gsv1.setSpecValue("红色");
		gsv1.setGoodId(1);
		GoodSpecValueEntity gsv2 = new GoodSpecValueEntity();
		gsv2.setId(2);
		gsv2.setCategorySpecId(1);
		gsv2.setSpecValue("白色");
		gsv2.setGoodId(1);
		GoodSpecValueEntity gsv3 = new GoodSpecValueEntity();
		gsv3.setId(3);
		gsv3.setCategorySpecId(1);
		gsv3.setSpecValue("蓝色");
		gsv3.setGoodId(1);

		GoodSpecValueEntity gsv11 = new GoodSpecValueEntity();
		gsv11.setId(4);
		gsv11.setCategorySpecId(2);
		gsv11.setSpecValue("大");
		gsv11.setGoodId(1);
		GoodSpecValueEntity gsv12 = new GoodSpecValueEntity();
		gsv12.setId(5);
		gsv12.setCategorySpecId(2);
		gsv12.setSpecValue("中");
		gsv12.setGoodId(1);
		GoodSpecValueEntity gsv13 = new GoodSpecValueEntity();
		gsv13.setId(6);
		gsv13.setCategorySpecId(2);
		gsv13.setSpecValue("小");
		gsv13.setGoodId(1);

		GoodSpecValueEntity gsv21 = new GoodSpecValueEntity();
		gsv21.setId(7);
		gsv21.setCategorySpecId(3);
		gsv21.setSpecValue("长");
		gsv21.setGoodId(1);
		GoodSpecValueEntity gsv22 = new GoodSpecValueEntity();
		gsv22.setId(8);
		gsv22.setCategorySpecId(3);
		gsv22.setSpecValue("短");
		gsv22.setGoodId(1);
		list.add(gsv1);
		list.add(gsv2);
		list.add(gsv3);
		list.add(gsv11);
		list.add(gsv12);
		list.add(gsv13);
		list.add(gsv21);
		list.add(gsv22);
		/*
		 * list.sort((GoodSpecValueEntity o1, GoodSpecValueEntity
		 * o2)->o1.getCategorySpecId()-o2.getCategorySpecId()); list.forEach( e ->
		 * System.out.println(e.getCategorySpecId()));
		 */
		List list2 = getTypeList(list, new ArrayList());
		System.out.println(list2.size());

		List<GoodSpecPriceEntity> list3 = get(list2, new ArrayList());
		list3.forEach(e -> System.out.println(e));
		
		GoodSpecPriceEntity gsep = new GoodSpecPriceEntity();
		gsep.setGoodId(1);
		 List<GoodSpecPriceEntity> list34 = new ArrayList();
		 list34.add(gsep);
		 List<GoodSpecPriceEntity> resu = get(list2,list34);
		 resu.forEach(e -> System.out.println( e.getSpec()));
 		
	}

	public List<GoodSpecPriceEntity> get(List<List<GoodSpecValueEntity>> list, List<GoodSpecPriceEntity> listR) {
		
		List<GoodSpecPriceEntity> testList = new ArrayList();
		if(list.isEmpty()) {
			return testList;
		}
		if(listR.isEmpty()) {
			return testList;
		}
		 
		sf: for (int j = 0; j < listR.size(); j++) {

			for (int i = 0; i < list.size(); i++) {

			 
				GoodSpecPriceEntity gspe = 	listR.get(j);
				 String sp =  gspe.getSpec();
				 if(sp == null) {
					 sp ="";
				 }
				 if(!StringUtils.isEmpty(sp)) {
					 sp += ",";
				 }
				 
				List<GoodSpecValueEntity> l = list.get(i);
				for (GoodSpecValueEntity gsve : l) {
					GoodSpecPriceEntity gspeEn = new GoodSpecPriceEntity();;
					Integer c = gsve.getId();
					
					BeanUtil.copyProperties(gspe, gspeEn);
					gspeEn.setSpec(sp+c);
					testList.add(gspeEn);

				}
				
				
				if (j < listR.size()-1) {
					continue sf;
				} else {
					listR.clear();
					list.remove(0);
				
				}
				if (list.isEmpty() || list == null) {
					return testList;
				}
				return get(list, testList);
 			}
			
			

		}
		return get(list, testList);

	}

	public List getTypeList(List<GoodSpecValueEntity> list, List listR) {

		for (int i = 0; i < list.size(); i++) {
			GoodSpecValueEntity gsve = list.get(i);
			List gsvList = getL(gsve, list);
			listR.add(gsvList);
			list.removeAll(gsvList);
			if (list.isEmpty()) {
				return listR;
			}
			getTypeList(list, listR);

		}

		return listR;
	}

	public List<GoodSpecValueEntity> getL(GoodSpecValueEntity e, List<GoodSpecValueEntity> list) {
		List listR = new ArrayList();

		Integer x = e.getCategorySpecId();
		GoodSpecValueEntity en = null;
		for (GoodSpecValueEntity goodSpecValueEntity : list) {
			if (goodSpecValueEntity.getCategorySpecId().equals(x)) {
				listR.add(goodSpecValueEntity);
			}

		}

		return listR;
	}
}
