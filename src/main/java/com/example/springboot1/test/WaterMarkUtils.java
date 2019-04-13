package com.example.springboot1.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * @author liang.xiongwei
 * @version V1.0
 * @Title: WaterMarkUtils
 * @Package com.example.springboot1.test
 * @Description   用java实现给图片增加图片水印或者文字水印（也支持视频图像帧添加水印）https://blog.csdn.net/eguid_1/article/details/52973508
 * @date 2018/9/13 16:36
 */
public class WaterMarkUtils {
    // 加文字水印
    public void mark(BufferedImage bufImg, Image img, String text, Font font, Color color, int x, int y) {
        Graphics2D g = bufImg.createGraphics();
        g.drawImage(img, 0, 0, bufImg.getWidth(), bufImg.getHeight(), null);
        g.setColor(color);
        g.setFont(font);
        g.drawString(text, x, y);
        g.dispose();
    }

    // 加图片水印
    public void mark(BufferedImage bufImg, Image img, Image markImg, int width, int height, int x, int y) {
        Graphics2D g = bufImg.createGraphics();
        g.drawImage(img, 0, 0, bufImg.getWidth(), bufImg.getHeight(), null);
        g.drawImage(markImg, x, y, width, height, null);
        g.dispose();
    }


    /**
     * 给图片增加文字水印
     *
     * @param imgPath
     *            -要添加水印的图片路径
     * @param outImgPath
     *            -输出路径
     * @param text-文字
     * @param font
     *            -字体
     * @param color
     *            -颜色
     * @param x
     *            -文字位于当前图片的横坐标
     * @param y
     *            -文字位于当前图片的竖坐标
     */
    public void mark(String imgPath, String outImgPath, String text, Font font, Color color, int x, int y) {
        try {
            // 读取原图片信息
            File imgFile = null;
            Image img = null;
            if (imgPath != null) {
                imgFile = new File(imgPath);
            }
            if (imgFile != null && imgFile.exists() && imgFile.isFile() && imgFile.canRead()) {
                img = ImageIO.read(imgFile);
            }
            int imgWidth = img.getWidth(null);
            int imgHeight = img.getHeight(null);
            // 加水印
            BufferedImage bufImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
            mark(bufImg, img, text, font, color, x, y);
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(outImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 给图片增加图片水印
     *
     * @param inputImg
     *            -源图片，要添加水印的图片
     * @param markImg
     *            - 水印图片
     * @param outputImg
     *            -输出图片(可以是源图片)
     * @param width
     *            - 水印图片宽度
     * @param height
     *            -水印图片高度
     * @param x
     *            -横坐标，相对于源图片
     * @param y
     *            -纵坐标，同上
     */
    public void mark(String inputImg, String markImg, String outputImg, int width, int height, int x, int y) {
        // 读取原图片信息
        File inputImgFile = null;
        File markImgFile = null;
        Image img = null;
        Image mark = null;
        try {
            if (inputImg != null && markImg != null) {
                inputImgFile = new File(inputImg);
                markImgFile = new File(markImg);
            }
            if (inputImgFile != null && inputImgFile.exists() && inputImgFile.isFile() && inputImgFile.canRead()) {

                img = ImageIO.read(inputImgFile);

            }
            if (markImgFile != null && markImgFile.exists() && markImgFile.isFile() && markImgFile.canRead()) {

                mark = ImageIO.read(markImgFile);

            }
            int imgWidth = img.getWidth(null);
            int imgHeight = img.getHeight(null);
            BufferedImage bufImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
            mark(bufImg, img, mark, width, height, x, y);
            FileOutputStream outImgStream = new FileOutputStream(outputImg);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Font font = new Font("宋体", Font.PLAIN, 14);
        // 原图位置, 输出图片位置, 水印文字颜色, 水印文字
         new WaterMarkUtils().mark("D:/hhhh.jpg", "D:/hhhh1.jpg", "水印效果测试", font, Color.ORANGE, 140, 14);
        // 增加图片水印
//        new WaterMarkUtils().mark("D:/hhhh.jpg", "D:/hhhh1.jpg", "goods", 40, 20, 0, 14);
    }

}