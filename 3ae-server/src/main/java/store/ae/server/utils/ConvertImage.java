package store.ae.server.utils;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ConvertImage {

	/**
	 * 私有构造函数.
	 */
	private ConvertImage() {

	}

	/**
	 * YUV420SP转RGB格式.
	 * 
	 * @param yuv420sp
	 *            YUV420SP格式文件数据
	 * @param width
	 *            图片宽像素
	 * @param height
	 *            图片高像素
	 * @param toPath
	 *            RGB图片存储路径
	 * @throws Exception
	 *             异常
	 */
	public static void yuv420SPToRGB(byte[] yuv420sp, int width, int height, String toPath) throws Exception {
		final int frameSize = width * height;
		int[] rgb = new int[frameSize];
		for (int j = 0, yp = 0; j < height; j++) {
			int uvp = frameSize + (j >> 1) * width, u = 0, v = 0;
			for (int i = 0; i < width; i++, yp++) {
				int y = (0xff & ((int) yuv420sp[yp])) - 16;
				if (y < 0)
					y = 0;
				if ((i & 1) == 0) {
					v = (0xff & yuv420sp[uvp++]) - 128;
					u = (0xff & yuv420sp[uvp++]) - 128;
				}
				int y1192 = 1192 * y;
				int r = (y1192 + 1634 * v);
				int g = (y1192 - 833 * v - 400 * u);
				int b = (y1192 + 2066 * u);

				if (r < 0)
					r = 0;
				else if (r > 262143)
					r = 262143;
				if (g < 0)
					g = 0;
				else if (g > 262143)
					g = 262143;
				if (b < 0)
					b = 0;
				else if (b > 262143)
					b = 262143;

				rgb[yp] = 0xff000000 | ((r << 6) & 0xff0000) | ((g >> 2) & 0xff00) | ((b >> 10) & 0xff);
			}
		}
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		bufferedImage.setRGB(0, 0, width, height, rgb, 0, width);
		ImageIO.write(bufferedImage, "JPG", new File(toPath));
	}

	/**
	 * YUV422SP转RGB格式.
	 * 
	 * @param yuv422sp
	 *            YUV422SP格式文件数据
	 * @param width
	 *            图片宽像素
	 * @param height
	 *            图片高像素
	 * @param toPath
	 *            RGB图片存储路径
	 * @throws Exception
	 *             异常
	 */
	public static void yuv422SPToRGB(byte[] yuv422sp, int width, int height, String toPath) throws Exception {
		final int frameSize = width * height;
		int[] rgb = new int[frameSize];
		for (int j = 0, yp = 0; j < height; j++) {
			int uvp = frameSize + j * width, u = 0, v = 0;
			for (int i = 0; i < width; i++, yp++) {
				int y = (0xff & ((int) yuv422sp[yp])) - 16;
				if (y < 0)
					y = 0;
				if ((i & 1) == 0) {
					u = (0xff & yuv422sp[uvp++]) - 128;
					v = (0xff & yuv422sp[uvp++]) - 128;
				}
				int y1192 = 1192 * y;
				int r = (y1192 + 1634 * v);
				int g = (y1192 - 833 * v - 400 * u);
				int b = (y1192 + 2066 * u);

				if (r < 0)
					r = 0;
				else if (r > 262143)
					r = 262143;
				if (g < 0)
					g = 0;
				else if (g > 262143)
					g = 262143;
				if (b < 0)
					b = 0;
				else if (b > 262143)
					b = 262143;

				rgb[yp] = 0xff000000 | ((r << 6) & 0xff0000) | ((g >> 2) & 0xff00) | ((b >> 10) & 0xff);
			}
		}
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		bufferedImage.setRGB(0, 0, width, height, rgb, 0, width);
		ImageIO.write(bufferedImage, "JPG", new File(toPath));
	}
}
