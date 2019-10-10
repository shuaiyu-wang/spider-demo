package com.bds.tokenTest.test.tmall;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by guoyu on 2016/3/10.
 */
public class ImgUtils {

    /**
     * 压缩图片的方法
     *
     * @param srcFile      要压缩的图片文件
     * @param compressRate 压缩倍率
     * @param quality      压缩质量（0.0-1.0）
     */
    public File compressImage(File srcFile, int compressRate, float quality) throws Exception {
        File tmpFile = new File(srcFile.getPath());
        Image src = ImageIO.read(tmpFile);
        BufferedImage tag = new BufferedImage(
                src.getWidth(null) / compressRate,
                src.getHeight(null) / compressRate,
                BufferedImage.TYPE_INT_RGB);

        tag.getGraphics().drawImage(src.getScaledInstance(
                src.getWidth(null) / compressRate,
                src.getHeight(null) / compressRate,
                Image.SCALE_FAST), 0, 0, null);

        FileOutputStream newimage = new FileOutputStream(new File(srcFile.getPath()));
        //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
        //JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
                /* 压缩质量 */
        //jep.setQuality(quality, true);
        //encoder.encode(tag, jep);
        ImageWriteParam imageWriteParam=new JPEGImageWriteParam(null);
        imageWriteParam.setCompressionMode(imageWriteParam.MODE_EXPLICIT);
        imageWriteParam.setCompressionQuality(quality);
        ImageWriter imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
        imgWrier.setOutput(ImageIO.createImageOutputStream(newimage));
        // 调用write方法，就可以向输入流写图片
        imgWrier.write(null, new IIOImage(tag, null, null), imageWriteParam);
        //ImageIO.write(tag, "png", newimage);
        tag.flush();
        newimage.close();

        return new File(srcFile.getPath());
    }
}
