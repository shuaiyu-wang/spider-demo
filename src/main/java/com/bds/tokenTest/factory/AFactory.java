package com.bds.tokenTest.factory;

public class AFactory implements Factory{

	@Override
	public Pizza createFactory() {
		// TODO Auto-generated method stub
		return new APizza();
	}

	@Override
	public Hamburger createHamburger() {
		// TODO Auto-generated method stub
		return new AHamburger();
	}

}
