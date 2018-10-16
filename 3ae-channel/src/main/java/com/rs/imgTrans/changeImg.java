package com.rs.imgTrans;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class changeImg {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		File imgFile =new File("E:/frame.yuv");
		try{			
			long fileSize = imgFile.length();
			
	        if (fileSize > Integer.MAX_VALUE) {  
	            System.out.println("file too big...");
	        } else {
	        	System.out.println(fileSize);
	        }
	        
	        FileInputStream fi = new FileInputStream(imgFile);  
	        byte[] buffer = new byte[(int) fileSize];
	        int offset = 0;  
	        int numRead = 0;  
	        while (offset < buffer.length  
	        && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {  
	            offset += numRead;  
	        }  
	        // 确保所有数据均被读取  
	        if (offset != buffer.length) {  
	        throw new IOException("Could not completely read file "  
	                    + imgFile.getName());  
	        }  
	        fi.close();
			int width = 720;
			int height = 576;
			int[] RGB = YUVtoRGB.NV12ToRGB(buffer,width,height);
			System.out.println(RGB);
			BufferedImage newbuff=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			newbuff.setRGB(0,0,width,height,RGB,0,720);
			ImageIO.write(newbuff,"jpg",new File("E:/yy45.jpg"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
