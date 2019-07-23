package store.ae.server.utils;

import java.text.SimpleDateFormat;

public class FormatUtil {
	
	
	/**
	 * 
	 * 获取服务器时间
	 * 
	 * @return
	 */
	public String getTime() {
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return time.format(System.currentTimeMillis());
	}
	
	/**	
	 * 
	 * 字节数组转字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public String byteToString(byte[] bytes) {
		StringBuffer buf = new StringBuffer();
		   for (byte b : bytes) {
				int d = b & 0xFF;
				String v = Integer.toHexString(d).toUpperCase();
				if (v.length() == 1) {
					v = "0" + v;
				}
				buf.append(v + " ");
			}
		return buf.toString();
	}
	
	/**
	 * 字符串拼接，代替+
	 * @param a
	 * @param b
	 * @return
	 */
	public String msgr(String a, String b) {
		
		StringBuffer contentBuffer = new StringBuffer();
		
		contentBuffer.append(a);
		contentBuffer.append(b);
		
		return contentBuffer.toString();
	}
	
	@SuppressWarnings("unused")
	private Boolean check(byte[] bytes, int len) {
		int sum = 0;
		   
		for (int i = 0; i < len-3; i++) {
			sum = bytes[i] & 0xff;
		   
		    sum += sum;
	    }
	   
	    sum = sum & 0xff;
	    
	    if(sum != bytes[len-3]) {
		    return false;
	    }
	    
	    return true;
	}
}
