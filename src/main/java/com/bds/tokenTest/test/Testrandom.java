package com.bds.tokenTest.test;

import java.util.Random;

public class Testrandom {
	
	private String name;
	
	private Integer id;
	
	
	public Testrandom(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}


	public Testrandom(String name) {
		super();
		this.name = name;
	}


	public static void main(String[] args) {
//		System.out.println(Math.random()*10);
//		System.out.println(getResult("120.0913701",13));
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			
			int node = r.nextInt(5);
			System.out.println(node);
		}
	}
	
//	public static String getResult(String LatLngStr,int needLength){
//		
//		String str = "_token=eJxtjluvmkAUhf8Lr9hyGWDgJH2AA8gAKhcBpekDNxFQdAQUbPrfi%2Bl5aE%2BaTGbttfLtnfWTuKGceGNommaEBdF388wDjmF5kWcEjlsQ2d8ZhByACyK9hSrx9h0I9IKD4o9X4M3%2BO0OL9ILhAPdj8ffMcvN7UWiGiGtSFh2VHZO2LU5fXu4fQyw%2BiKrNi%2FHPT8zL5%2B28PGvzoclLCRZ%2BBQC82ouAoXkOLgTmc3Kvisd8FfJfBUGQJElkBFHieLDg2c%2FJBwqkzzcg%2BC869%2Bg%2F%2BnRV2RJvRGFOUrNiBvYpu8c1pSsSaKrqjo%2BPrNDVQlGTnKn6o6nKrpuYepQEQ%2BX3VgSt7G4m68s7ufV90MK43Y8T3wRPdPWFoB9sgS0VOSyuXkVpB5Tk1%2BR0puoen%2Fb0UHjBLb%2BtUV92%2BzxrJ9qxwKCeHEMknx3TpXCKTr61U71MUiO%2B5PXQXWpq6p0r657GVY4lehsal%2BSg1T002SpcIi3wrs2gylOOMkMM43DD%2BQHdDPmS10wXpxm7jw8xKW6fU93bTK6DskWUlxhBqNITY7GkDa%2F1yvHSJyb7lqFKHLfHdd0Ny35g2cjOC2O5m%2BKbaDjb24WEukjZEi%2BM9qYVyh2X4HNUrJIaRn28a9D58UhIE985u2TcTC4SDICQuo9sauTRLbdHBQELiLaJ8rux4acG78kjUrmNX2hPrQlIiDAaYb9fyWYxstv1dTngdFO2N6F%2Fhn25xcDeNdBt7XOFkKxrokkWSYfTyn3XrX164W9pH0VlHQbro4%2FjC43weLV4AC6KOFoH%2FbkSi5JVggMGGg2qRF1hY4oDHEcOFYt9LaADRaF8EqhHV6feYFSbyKxk35EE5SzmI684740%2BOG4nr%2FRp6Zi1qNSOJrfyt2%2FEr99QjB2u"
//				+ "&page_index=0"
//				+ "&page_size=20"
//				+ "&load_type=1"
//				+ "&slider_select_data=%22%22"
//				+ "&sort_type=0"
//				+ "&category_type=910"
//				+ "&navigate_type=910"
//				+ "&open_id=oOpUI0UK2bx7Kj8aX2VvHSkHsCfs"
//				+ "&uuid=af6b4788-42c9-439c-a955-2bc5d6b6ea92&platform=13&partner=4&riskLevel=1&user_id=161191471&userid=161191471&wm_actual_latitude=31272194&wm_actual_longitude=121384254&waimai_sign=%2F&req_time=1534125877403&userToken=8Y18pchUwsFc6OwxCzEz2ArH9ssAAAAATwYAAKTjC2MHT2-AurmjfWDIXx1dAPlV2dOKoK4Cd5YWggy3ai3n2N7O6B8010B2rdof8Q&wm_logintoken=8Y18pchUwsFc6OwxCzEz2ArH9ssAAAAATwYAAKTjC2MHT2-AurmjfWDIXx1dAPlV2dOKoK4Cd5YWggy3ai3n2N7O6B8010B2rdof8Q&wm_appversion=2.9.1&wm_visitid=41a872e7-6b29-4465-99a1-425324a4c3d5&wm_latitude=31272194&wm_longitude=121384254&wm_uuid=af6b4788-42c9-439c-a955-2bc5d6b6ea92&wm_dversion=6.6.7&wm_dtype=PIC-AL00&wm_ctype=wxapp";
//		
//		String result = "" ;
//		String lat = LatLngStr;
//		String lStrings = lat.split("\\.")[1] ;
//		String addStr = "" ;
//		if (lStrings.length() == needLength) {
//			result = LatLngStr ;
//		}else {
//			int addLength = 10 - lStrings.length();
//			for (int i = 0; i < addLength; i++) {
//				int random=(int)(Math.random()*10); 
//				addStr = addStr  + random ;
//			}
//			result =  LatLngStr + addStr ;
//		}
//		return result ;
//	}
}
