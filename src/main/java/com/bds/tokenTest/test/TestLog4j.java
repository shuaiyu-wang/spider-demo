package com.bds.tokenTest.test;

import org.apache.log4j.Logger;

public class TestLog4j {
	
	public static void main(String[] args) {
		Logger log = Logger.getLogger(TestLog4j.class);
		log.info("aaa");
	}
}
