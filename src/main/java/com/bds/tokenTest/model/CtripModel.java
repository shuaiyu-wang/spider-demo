package com.bds.tokenTest.model;

public class CtripModel {
	
	private Integer id;
	
	private String houseType;
	
	private String favourable;//优惠
	
	private String bedType;
	
	private String breakfast;
	
	private String network;
	
	private String personNum;
	
	private String policy;
	
	private String base_price;
	
	private String payType;
	
	private String area;
	
	private String floor;
	
	private String bed;
	
	private String window;
	
	private String addBed;
	
	private String yan;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	public String getWindow() {
		return window;
	}

	public void setWindow(String window) {
		this.window = window;
	}

	public String getAddBed() {
		return addBed;
	}

	public void setAddBed(String addBed) {
		this.addBed = addBed;
	}

	public String getYan() {
		return yan;
	}

	public void setYan(String yan) {
		this.yan = yan;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getFavourable() {
		return favourable;
	}

	public void setFavourable(String favourable) {
		this.favourable = favourable;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getPersonNum() {
		return personNum;
	}

	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getBase_price() {
		return base_price;
	}

	public void setBase_price(String base_price) {
		this.base_price = base_price;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	@Override
	public String toString() {
		return "CtripModel [id=" + id + ", houseType=" + houseType + ", favourable=" + favourable + ", bedType="
				+ bedType + ", breakfast=" + breakfast + ", network=" + network + ", personNum=" + personNum
				+ ", policy=" + policy + ", base_price=" + base_price + ", payType=" + payType + ", area=" + area
				+ ", floor=" + floor + ", bed=" + bed + ", window=" + window + ", addBed=" + addBed + ", yan=" + yan
				+ "]";
	}
	
}
