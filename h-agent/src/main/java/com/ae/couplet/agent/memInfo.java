package com.ae.couplet.agent;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

public class memInfo {
	public static void cpuLength(Sigar sigar) {
			int cpuLength;
			try {
				cpuLength = sigar.getCpuInfoList().length;
				System.out.println(cpuLength);
			} catch (SigarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void cpuInfo(Sigar sigar) {
		CpuInfo infos[];
		try {
			infos = sigar.getCpuInfoList();
			for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用 
			    CpuInfo info = infos[i]; 
			    System.out.println("mhz=" + info.getMhz());// CPU的总量MHz 
			    System.out.println("vendor=" + info.getVendor());// 获得CPU的卖主，如：Intel 
			    System.out.println("model=" + info.getModel());// 获得CPU的类别，如：Celeron 
			    System.out.println("cache size=" + info.getCacheSize());// 缓冲存储器数量 
			}
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void cpuPerc(Sigar sigar) {
		CpuPerc cpu; 
		try { 
		    cpu = sigar.getCpuPerc(); 
		    System.out.println(cpu); 
		} catch (SigarException e) { 
		    e.printStackTrace(); 
		}
	}
	
	public static void cpuMapPerc(Sigar sigar) {
		CpuPerc cpuList[] = null; 
		try { 
		    cpuList = sigar.getCpuPercList(); 
		} catch (SigarException e) { 
		    e.printStackTrace(); 
		} 
		for (int i = 0; i < cpuList.length; i++) { 
		    // printCpuPerc(cpuList[i]); 
		}
	}
	
	public static void menCache(Sigar sigar) {
		Mem mem;
		try {
			mem = sigar.getMem();
			// 内存总量 
			System.out.println("Total = " + mem.getTotal() / 1024L / 1024 + "M av"); 
			// 当前内存使用量 
			System.out.println("Used = " + mem.getUsed() / 1024L / 1024 + "M used"); 
			// 当前内存剩余量 
			System.out.println("Free = " + mem.getFree() / 1024L / 1024 + "M free"); 
			   
			// 系统页面文件交换区信息 
			Swap swap = sigar.getSwap(); 
			// 交换区总量 
			System.out.println("Total = " + swap.getTotal() / 1024L + "K av"); 
			// 当前交换区使用量 
			System.out.println("Used = " + swap.getUsed() / 1024L + "K used"); 
			// 当前交换区剩余量 
			System.out.println("Free = " + swap.getFree() / 1024L + "K free");
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
		
	
	public static void main(String[] args) {
		Sigar sigar = new Sigar();
		
		// CPU数量（单位：个）
		cpuLength(sigar);
		
		// CPU的总量（单位：HZ）及CPU的相关信息 
		cpuInfo(sigar);
		
		/** CPU的用户使用量、系统使用剩余量、总的剩余量、总的使用占用量等（单位：100%） **/
		// 方式一，主要是针对一块CPU的情况
		cpuPerc(sigar);
		
		// 方式二，不管是单块CPU还是多CPU都适用
		cpuMapPerc(sigar);
		
		// 物理内存信息 
		menCache(sigar);
		
	}	
}