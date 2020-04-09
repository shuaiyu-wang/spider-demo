package com.zmf.youdao;

import com.bds.tokenTest.util.Util;

public class GetSign {

	public static void main(String[] args) throws Exception {
//		String keyword = "你好";
//		String i = "15794906626650";
//		String sign = Util.getMd5("fanyideskweb"+keyword+i+"n%A-rKaT5fb[Gy?;N5@Tj");
//		System.out.println(sign);//"075b091992e911eaf3fe3cb3b9af19ae"
//		"client=webapp&sl=zh-CN&tl=en&hl=zh-CN&dt=at&dt=bd&dt=ex&dt=ld&dt=md&dt=qca&dt=rw&dt=rm&dt=ss&dt=t&source=bh&ssel=0&tsel=0&kc=1"
		String url2="https://capi.luckincoffee.com/resource/m/shop/shopList?q=CjmQmGG6yaZQifYN-5heXzn7sPEw8nYdRkiB64sfh1hlNtWaVuitHXxKvmuQiaerdGnJjaAzXGIRxl1nZaKxNK4x3NjaZT-aB5KwNxk9Bk3If9d92VsMzy7ocnTCE8LBuLE9_N002vHhCG_p9TgNtLeJ9azLUvy7URUOqZ5M0DZPvg0G8TsrG9Amrzt8lh8o&cid=210101&uid=acd0bf7f-888f-4c13-b5d6-e35080cc4dae1583298673562&sign=915435957480707865703722019771287443";
	    System.out.println(Util.doGet(url2,null));
	}
}
