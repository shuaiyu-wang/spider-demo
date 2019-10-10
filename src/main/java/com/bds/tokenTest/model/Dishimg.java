package com.bds.tokenTest.model;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("dianping_restaurant_dish_img")
public class Dishimg {
	
	@Id
	private Integer RID;
	
	@Column
	private String request_id;
	
	@Column
	private String shop_id;
	
	@Column
	private String dish_name;
	
	@Column
	private String recommend_cnt;
	
	@Column
	private String price;
	
	@Column
	private Date create_time;
	
	@Column
	private String pic_url;

	public Integer getRID() {
		return RID;
	}

	public void setRID(Integer rID) {
		RID = rID;
	}


	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}

	public String getRecommend_cnt() {
		return recommend_cnt;
	}

	public void setRecommend_cnt(String recommend_cnt) {
		this.recommend_cnt = recommend_cnt;
	}

	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	@Override
	public String toString() {
		return "Dishimg [RID=" + RID + ", request_id=" + request_id + ", shop_id=" + shop_id + ", dish_name="
				+ dish_name + ", recommend_cnt=" + recommend_cnt + ", price=" + price + ", create_time=" + create_time
				+ ", pic_url=" + pic_url + "]";
	}
	
	

}
