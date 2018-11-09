package store.ae.imgTrans;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/* 源代码
RGB转YUV:
Y = 0.299 R + 0.587 G + 0.114 B
U = - 0.1687 R - 0.3313 G + 0.5 B + 128
V = 0.5 R - 0.4187 G - 0.0813 B + 128

YUV转RGB
R = Y + 1.402 (V - 128)
G = Y - 0.34414 (U - 128) - 0.71414 (V - 128)
B = Y + 1.772 (U - 128)
*/

// 模拟YUV->模拟RGB
// BT601(标清)
//***************************BT601*****************************//
//Y = 0.299 * R + 0.587 * G + 0.114 * B          　　　　	   //
//Pb =-0.169 * R - 0.331 * G + 0.500 * B                       //
//Pr = 0.500 * R - 0.439 * G - 0.081 * B                       //
//R = Y + 1.402* Pr                    　　　　　　　　　　　　　				   //
//G = Y - 0.344 * Pb  - 0.792* Pr　　 　　　　　　　　　　　　　　	   //
//B = Y + 1.772 * Pb                    　　　　　　　　　　　　 				   //
//***************************BT601*****************************//

// BT709(高清)
//***************************BT709*****************************//
//Y = 0.213 * R + 0.715 * G + 0.072 * B         　　　　       //
//Pb =-0.115 * R - 0.385 * G + 0.500 * B                       //
//Pr = 0.500 * R - 0.454 * G - 0.046 * B                       //
//R = Y + 1.402* Cr                    　　　　　　　　　　　　　				   //
//G = Y - 0.344 * Cb  - 0.792* Cr　　 　　　　　　　　　　　　　　	   //
//B = Y + 1.772 * Cb                    　　　　　　　　　　　　 				   //
//***************************BT709*****************************//

// 数字YUV->数字RGB
// BT601
//*********************BT601***********************************//
//Y = 16  + 0.257 * R + 0.504 * g + 0.098 * b                  //
//Cb = 128 - 0.148 * R - 0.291 * g + 0.439 * b                 //
//Cr = 128 + 0.439 * R - 0.368 * g - 0.071 * b                 //
//R = 1.164 *(Y - 16) + 1.596 *(Cr - 128)                      //
//G = 1.164 *(Y - 16) - 0.392 *(Cb - 128) - 0.812 *(Cr - 128)  //
//B = 1.164 *(Y - 16) + 2.016 *(Cb - 128)                      //
//*********************BT601***********************************//

//*********************BT709***********************************//
//Y = 16  + 0.183 * R + 0.614 * g + 0.062 * b                  //
//Cb = 128 - 0.101 * R - 0.339 * g + 0.439 * b                 //
//Cr = 128 + 0.439 * R - 0.399 * g - 0.040 * b                 //
//R = 1.164 *(Y - 16) + 1.792 *(Cr - 128)                      //
//G = 1.164 *(Y - 16) - 0.213 *(Cb - 128) - 0.534 *(Cr - 128)  //
//B = 1.164 *(Y - 16) + 2.114 *(Cb - 128)                      //
//*********************BT709***********************************//

public class RGBtoYUV420SP {
	public static void main(String[] args) {
		File imgFile =new File("E:/123.jpg");
		try{
			BufferedImage bufferedImage = ImageIO.read(imgFile);
			int width = bufferedImage.getWidth();
			int height = bufferedImage.getHeight();
			int[] pixels = bufferedImage.getRGB(0,0,width,height,null,0,width);
			byte[] yuvs=encodeYUV420SP(pixels,width,height);
			int[] pixelsNew=ColorUtil.decodeYUV420sp(yuvs,width,height);
			BufferedImage newbuff=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			newbuff.setRGB(0,0,width,height,pixelsNew,0,width);
			ImageIO.write(newbuff,"yuv",new File("E:/1.yuv"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] encodeYUV420SP(int[] argb,int width,int height){
		int size = (int) ((Math.ceil(width/2.0)) * (Math.ceil(height/2.0)));
		int frameSize = width * height;
		byte[] yuvs=new byte[frameSize + size *2];
		int y=0,u=0,v=0;
		@SuppressWarnings("unused")
		int r=0,g=0,b=0,a=0;
		int index=0,uvindex=frameSize;
		for(int i=0; i < height; i++) {
			for(int j =0; j < width; j++) {
				a = (argb[index] &0xff000000) >>24;// a is not used obviously
				r = (argb[index] &0xff0000) >>16;
				g = (argb[index] &0xff00) >>8;
				b = (argb[index] &0xff) >>0;
				
				//Y = 0.213 * R + 0.715 * G + 0.072 * B         　　　　       //
				//Pb =-0.115 * R - 0.385 * G + 0.500 * B                       //
				//Pr = 0.500 * R - 0.454 * G - 0.046 * B                       //
				//R = Y + 1.402* Cr                    　　　　　　　　　　　　　				   //
				//G = Y - 0.344 * Cb  - 0.792* Cr　　 　　　　　　　　　　　　　　	   //
				//B = Y + 1.772 * Cb       			
				//转换公式
				//				y= (int) (0.299*r +0.587*g +0.114*b);
				//				u= (int) (-0.169*r -0.331*g +0.5*b +128);
				//				v= (int) (0.5*r -0.419*g -0.081*b +128);
				y= (int) (0.213*r +0.715*g +0.072*b);
				u= (int) (-0.115*r -0.385*g +0.500*b +128);
				v= (int) (0.500*r -0.454*g -0.046*b +128);
				System.out.println("x:"+i+"y:"+j+"  y:"+y+" u:"+u+" v:"+v);
				yuvs[index++] = (byte) ((y <0) ?0: ((y >255) ?255: y));
				if(i%2==0&& j %2==0){
					yuvs[uvindex++] = (byte) ((u <0) ?0: ((u >255) ?255: u));
					yuvs[uvindex++] = (byte) ((v <0) ?0: ((v >255) ?255: v));
				}
			}
		}
		return yuvs;
	}
	
	

}
