package store.ae.server.couplet.info;
//package com.ae.couplet.server.info;
//
//import org.hyperic.sigar.Mem;
//import org.hyperic.sigar.Sigar;
//import org.hyperic.sigar.SigarException;
//import org.hyperic.sigar.Swap;
//
//public class memcache {
//	
//	
//	public static void memcacheMain(Sigar sigar) {
//		Mem mem;
//		try {
//			mem = sigar.getMem();
//			// 内存总量 
//			System.out.println("Total = " + mem.getTotal() / 1024L / 1024 + "M av"); 
//			// 当前内存使用量 
//			System.out.println("Used = " + mem.getUsed() / 1024L / 1024 + "M used"); 
//			// 当前内存剩余量 
//			System.out.println("Free = " + mem.getFree() / 1024L / 1024 + "M free"); 
//			   
//			// 系统页面文件交换区信息 
//			Swap swap = sigar.getSwap(); 
//			// 交换区总量 
//			System.out.println("交换区  Total = " + swap.getTotal() / 1024L /1024 /1024 + "G av");
//			System.out.println("交换区  Total = " + swap.getTotal() / 1024L /1024 + "M av");
//			// System.out.println("交换区  Total = " + swap.getTotal() / 1024L + "K av");
//			System.out.println("");
//			
//			// 当前交换区使用量
//			System.out.println("交换区 Used = " + swap.getUsed() / 1024L /1024 /1024 + "G used");
//			System.out.println("交换区 Used = " + swap.getUsed() / 1024L /1024 + "M used");
//			// System.out.println("交换区 Used = " + swap.getUsed() / 1024L + "K used");
//			System.out.println("");
//			// 当前交换区剩余量 
//			System.out.println("交换区 Free = " + swap.getFree() / 1024L /1024 /1024 + "G free");
//			System.out.println("交换区 Free = " + swap.getFree() / 1024L /1024 + "M free");
//			// System.out.println("交换区 Free = " + swap.getFree() / 1024L + "K free");
//			System.out.println("");
//		} catch (SigarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
//	}
//	
//		
//	
//	public static void main(String[] args) {
//		Sigar sigar = new Sigar();
//		
//		// 物理内存信息 
//		memcacheMain(sigar);
//		
//	}	
//}