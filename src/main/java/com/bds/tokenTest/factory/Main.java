package com.bds.tokenTest.factory;

public class Main {

	public static void main(String[] args) {
		Factory factory = new AFactory();
		Pizza pizza = factory.createFactory();
		pizza.getPizza();
		factory = new BFactory();
		pizza = factory.createFactory();
		pizza.getPizza();
	}
}
