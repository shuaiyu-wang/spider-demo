package com.bds.tokenTest.test.tmall;

import java.io.File;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.bds.base.http.HttpBase;

public class TmallAdhoc {

	public static NutDao getBiDao() {
		org.apache.commons.dbcp.BasicDataSource dataSource = new org.apache.commons.dbcp.BasicDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://211.152.47.68:1433;DatabaseName=DC_TMALL_ADHOC");
		dataSource.setUsername("xiaoyong.han");
		dataSource.setPassword("bds@123");
		NutDao dao = new NutDao(dataSource);
		return dao;
	}

	public static void main(String args[]) throws Exception {

		final NutDao dao = getBiDao();
		final int THREAD_COUNT = 5;
		for (int i = 0; i < THREAD_COUNT; i++) {
			final int node = i;
			new Thread() {
				public void run() {
					TmallAdhoc ta = new TmallAdhoc();
					WebDriver dr = HttpBase.getFirefoxDriver();
//					dr.get("https://detail.tmall.com/item.htm?id=15658129499");
					while(true) {
						List<Record> list = dao.query("tmall_product_images", Cnd.where("status", "=", 0).and("id%"+THREAD_COUNT,"=",node).limit(1, 10));
						if(CollectionUtils.isEmpty(list)) {
							break;
						}
						for (Record r : list) {
							String pid = r.getString("pid");
							try {
								String image = ta.image(dr, pid);
								if(StringUtils.isEmpty(image)) {
									dao.update("tmall_product_images", Chain.make("status", 3), Cnd.where("pid","=", pid));
								}else {
									dao.update("tmall_product_images", Chain.make("status", 2).add("img_url", image), Cnd.where("pid","=", pid));
								}
							} catch (Exception e) {
								dao.update("tmall_product_images", Chain.make("status", 3), Cnd.where("pid","=", pid));
							}
						}
					}
					dr.close();
				}
				
			}.start();
			
		}

	}

	public String image(WebDriver dr, String pid) throws Exception {
		String url = "https://detail.tmall.com/item.htm?id=" + pid;
		dr.get(url);
		
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("scrollTo(0,300)");
		Thread.sleep(3000);
		
		for(int i=0;i<8;i++) {
			js.executeScript("scrollTo(0,500)");
			Thread.sleep(2000);
		}
		js.executeScript("document.getElementById('J_TabBarBox').style='position:';");
		Thread.sleep(5000);
		File f = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);

		// WebElement element = dr.findElement(By.id("mainwrap"));
		// Point p = element.getLocation();
		// //获取元素的宽与高
		// int width = element.getSize().getWidth();
		// int height = element.getSize().getHeight();
		// //矩形图像对象
		// Rectangle rect = new Rectangle(width, height);
		// BufferedImage img = ImageIO.read(f);
		// //x、y表示加上当前frame的左边距,上边距
		// BufferedImage dest = img.getSubimage(p.getX(), p.getY(),rect.width,
		// rect.height);
		// ImageIO.write(dest, "png", f);

		ImgUtils imgUtils = new ImgUtils();
		//File destFile = imgUtils.compressImage(f, 1, 0.5F);
		String r_url = UploadOSSUtil.uploadFile(pid + ".jpg", f);
		try {
			f.deleteOnExit();
			//destFile.deleteOnExit();
		}catch(Exception e) {
		}
		System.out.println(pid+"\t"+r_url);
		return r_url;
	}

}
