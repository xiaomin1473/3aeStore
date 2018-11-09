package store.ae.imgTrans;

public class ColorUtil {
	public static int[] decodeYUV420sp(byte[] yuvs ,int width,int height){
		int frameSize = width * height;
		int[] rgbs =new int[frameSize];
		int index=0;
		int uvindex=frameSize;
		int u=0,v=0,y=0;
		for(int i =0; i < height; i++) {
			for(int j =0; j < width; j++) {
				if(i%2==0&& j %2==0){
					u=yuvs[uvindex++];
					v=yuvs[uvindex++];
				}
				//保存到数组中去
				y=yuvs[index];
				rgbs[index++]=yuv2Rgb(y,u,v);
			}
		}
		return rgbs;
	}
	
	public static int yuv2Rgb(int y,int u,int v){

		// 转换公式
		int r = (int) ((y&0xff)+1.402*((v&0xff) -128));
		int g = (int) ((y&0xff)-0.34414* ((u&0xff) -128) -0.71414* ((v&0xff) -128));
		int b = (int) ((y&0xff)+1.772* ((u&0xff) -128));

		r=(r<0?0:r>255?255:r);
		g=(g<0?0:g>255?255:g);
		b=(b<0?0:b>255?255:b);

		return(0xff<<24) + (r<<16) + (g<<8) + b;
	}
}
