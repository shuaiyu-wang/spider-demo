package com.zmf.elme;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bds.tokenTest.util.Util;

public class EleSearchThreadSecond {

	private static Logger logger = Logger.getLogger(EleSearchThreadSecond.class);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void doRun() {
			try {
				String zh = Util.read("C:\\Users\\wsy\\git\\test\\src\\main\\java\\com\\zmf\\elme\\json1.txt");
		        JSONObject zongheJson = JSONObject.parseObject(zh);
		        JSONArray items = zongheJson.getJSONArray("items");
				
				HashSet<String> set = new HashSet<String>();
				// && items.size()<=30
				if (items !=null && items.size() !=0) {
					set = insert(null, items, set);
				}
				if (items.size()>30) {
					return;
				}else {
					String sale = Util.read("C:\\Users\\wsy\\git\\test\\src\\main\\java\\com\\zmf\\elme\\json2.txt");
					JSONObject saleJson = JSONObject.parseObject(sale);
					items = saleJson.getJSONArray("items");
					if (items !=null && items.size() !=0 && items.size()<=30) {
						insert(null, items, set);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			
	}
	
	
	private HashSet<String> insert(Dao biDao,JSONArray items,HashSet<String> set) {
		HashSet<String> insertSet = new HashSet<String>();
		int newindex = 1;
			for (int i = 0; i < items.size(); i++) {
				JSONObject obj = items.getJSONObject(i);
				JSONObject restaurant = obj.getJSONObject("restaurant");
				int shop_ranking = i+1;
				
				String name = null;
				String shopId = "";
				
				if (restaurant !=null) {
					shopId = restaurant.getString("id");
					name = restaurant.getString("name");
					if (set.size()==0) {
//						insertSet = new HashSet<String>();
						if(!insertSet.add(shopId)) {
							continue;
						}else {
							shop_ranking=set.size()+newindex;
							newindex++;
						}
					}else {
						if (insertSet.contains(shopId) || !set.add(shopId)) {
							continue;
						}else {
							shop_ranking=set.size()+newindex;
							newindex++;
						}
					}
					if (shop_ranking >30) {
						break;
					}
				}
//				System.out.println(set.size()+"-"+insertSet.size()+"-"+insertSet);
				System.out.println("--------排名---"+shop_ranking+"--------shopname---"+name+"--------shopname---"+shopId);
				
			}
			return insertSet;
	}
	
	
	public static void main(String args[]) throws Exception {
		EleSearchThreadSecond est = new EleSearchThreadSecond();
		est.doRun();
		
		
	}

}
