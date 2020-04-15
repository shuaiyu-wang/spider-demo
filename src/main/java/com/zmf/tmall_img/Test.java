package com.zmf.tmall_img;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Test {

	public static void main(String[] args) throws Exception {
		// \\testt\\1\\1在磁盘根目录下新建文件夹
		// testt\\1\\1在项目根目录下新建文件夹
//		File file = new File("\\testt\\1\\图片");
//		// 如果路径不存在，新建
//		if (!file.exists() && !file.isDirectory()) {
//			file.mkdirs();
//		}
//		file = new File("\\testt\\1\\视频");
//		if (!file.exists() && !file.isDirectory()) {
//			file.mkdirs();
//		}
		//下载图片 图片url,保存路径及图片名称
		downloadpic("http://img.alicdn.com/imgextra/i3/4053842571/O1CN01gcwEGt1UrYq3TuOha_!!4053842571.jpg", "\\testt\\1\\图片\\test.jpg");
		//下载视频  视频url,保存路径及图片名称
//		downloadvideo("", "\\testt\\1\\图片\\test.mp4");
//		String dir = "E:\\EC_online2.zip";
//		System.out.println(dir.substring(0,dir.indexOf(".zip")));
//		File file = new File("E:\\EC_online2") ;
//		System.out.println(file.isDirectory());
	}

	// java 通过url下载图片保存到本地
	public static boolean downloadpic(String urlString, String filename) {
		try {
			// 构造URL
			URL url = new URL(urlString);
			// 打开连接
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// 输入流
			InputStream is = null;
			if(con.getResponseCode()==200) {
				is = con.getInputStream();
			}else {
				System.out.println(con.getResponseCode());
				is = con.getErrorStream();
			}
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			File file = new File(filename);
			FileOutputStream os = new FileOutputStream(file, true);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean downloadvideo(String httpUrl, String filename) {
        try {
        	int byteRead;
        	URL url = new URL(httpUrl);
            //获取链接
            URLConnection conn = url.openConnection();
            //输入流
            InputStream inStream = conn.getInputStream();
            //写入文件
            FileOutputStream fs = new FileOutputStream(filename);
            byte[] buffer = new byte[1024];
            while ((byteRead = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteRead);
            }
            inStream.close();
            fs.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
