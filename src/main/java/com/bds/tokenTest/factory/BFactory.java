package com.bds.tokenTest.factory;

public class BFactory implements Factory{

	@Override
	public Pizza createFactory() {
		// TODO Auto-generated method stub
		return new BPizza();
	}

	@Override
	public Hamburger createHamburger() {
		// TODO Auto-generated method stub
		return null;
	}

}
