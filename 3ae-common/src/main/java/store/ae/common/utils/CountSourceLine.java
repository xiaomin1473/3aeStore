package store.ae.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 读取项目源码行数
 * 
 * @author zym
 *
 */
public class CountSourceLine {

	private static String[] ext = null;
	private int total = 0;

	private void count(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			File[] fs = file.listFiles();
			for (File f : fs) {
				count(f.getAbsolutePath());
			}
		} else {
			for (String e : ext) {
				if (path.endsWith(e)) {
					countLine(new File(path));
					break;
				}
			}
		}
	}

	private void countLine(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((br.readLine()) != null) {
				total++;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void result() {
		System.out.println("共:" + total + "行");
	}

	public static void main(String[] args) {
		CountSourceLine c = new CountSourceLine();
		String path = "E:/program/rd59-parent";
		ext = new String[]{ ".java", ".xml", ".properties",".html",".js",".css",".htm" };
		//String path = "E:/program/rd60-parent";
		//ext = new String[]{ ".java", ".xml", ".properties" };
		
		c.count(path);
		c.result();
	}
}
