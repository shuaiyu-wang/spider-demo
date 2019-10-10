package com.bds.tokenTest.model;

import java.util.Date;

public class FacilitiesModel {
	
	private Integer id;
	
	private String pois_id;
	
	private String name;
	
	private String type;
	
	private String typecode;
	
	private String address;
	
	private String location;
	
	private String pcode;
	
	private String pname;
	
	private String citycode;
	
	private String cityname;
	
	private String adcode;
	
	private String adname;
	
	private String shopinfo;
	
	private String gridcode;
	
	private String distance;
	
	private String business_area;
	
	private Date create_date;
	
	private Date create_time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPois_id() {
		return pois_id;
	}

	public void setPois_id(String pois_id) {
		this.pois_id = pois_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getAdname() {
		return adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	public String getShopinfo() {
		return shopinfo;
	}

	public void setShopinfo(String shopinfo) {
		this.shopinfo = shopinfo;
	}

	public String getGridcode() {
		return gridcode;
	}

	public void setGridcode(String gridcode) {
		this.gridcode = gridcode;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getBusiness_area() {
		return business_area;
	}

	public void setBusiness_area(String business_area) {
		this.business_area = business_area;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "FacilitiesModel [id=" + id + ", pois_id=" + pois_id + ", name=" + name + ", type=" + type
				+ ", typecode=" + typecode + ", address=" + address + ", location=" + location + ", pcode=" + pcode
				+ ", pname=" + pname + ", citycode=" + citycode + ", cityname=" + cityname + ", adcode=" + adcode
				+ ", adname=" + adname + ", shopinfo=" + shopinfo + ", gridcode=" + gridcode + ", distance=" + distance
				+ ", business_area=" + business_area + ", create_date=" + create_date + ", create_time=" + create_time
				+ "]";
	}
	
	
}
