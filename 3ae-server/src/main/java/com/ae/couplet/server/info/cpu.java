//package com.ae.couplet.server.info;
//
//import org.hyperic.sigar.CpuInfo;
//import org.hyperic.sigar.CpuPerc;
//import org.hyperic.sigar.Sigar;
//import org.hyperic.sigar.SigarException;
//
//public class cpu {
//	public static void cpuLength(Sigar sigar) {
//		int cpuLength;
//		try {
//			cpuLength = sigar.getCpuInfoList().length;
//			
//			System.out.println("——————————————————————————— CPU Length ————————————————————————");
//			
//			System.out.println("cpu length = " + cpuLength);
//			System.out.println("——————————————————————————— CPU Length ————————————————————————\n\n\n");
//		} catch (SigarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public static void cpuInfo(Sigar sigar) {
//		CpuInfo infos[];
//		try {
//			infos = sigar.getCpuInfoList();
//		    System.out.println("———————————————————————————— CPU INFO —————————————————————————");
//
//			for (int i = 0; i < infos.length; i++) {
//				// 不管是单块CPU还是多CPU都适用 
//			    CpuInfo info = infos[i];
//			    
//			    // CPU的总量MHz
//			    System.out.println("MHz = " + info.getMhz());
//			    
//			    // 获得CPU的品牌，如：Intel 
//			    System.out.println("brand = " + info.getVendor());
//			    
//			    // 获得CPU的类别，如：Celeron 
//			    System.out.println("model = " + info.getModel());
//			    
//			    // 缓冲存储器数量
//			    System.out.println("cache size = " + info.getCacheSize());
//			    
//			    System.out.println("");
//			}
//			System.out.println("———————————————————————————— CPU INFO —————————————————————————\n\n\n");
//		} catch (SigarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//	}
//	
//	public static void cpuPerc(Sigar sigar) {
//		CpuPerc cpu; 
//		try { 
//		    cpu = sigar.getCpuPerc();
//		    System.out.println("——————————————————————————————— CPU Perc ——————————————————————————————");
//		    System.out.println(cpu);
//		    System.out.println("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
//	        System.out.println("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
//	        System.out.println("CPU当前等待率:    " + CpuPerc.format(cpu.getWait()));// 当前等待率
//	        System.out.println("CPU当前错误率:    " + CpuPerc.format(cpu.getNice()));//
//	        System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
//	        System.out.println("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
//
//		    System.out.println("——————————————————————————————— CPU Perc ——————————————————————————————\n\n\n");
//		} catch (SigarException e) { 
//		    e.printStackTrace(); 
//		}
//	}
//	
//	public static void cpuMapPerc(Sigar sigar) {
//		CpuPerc cpuList[] = null; 
//		try { 
//		    cpuList = sigar.getCpuPercList(); 
//		} catch (SigarException e) { 
//		    e.printStackTrace(); 
//		}
//		System.out.println("—————————————————————————————— CPU MapPerc ————————————————————————————");
//		for (int i = 0; i < cpuList.length; i++) {
//			int j = i+1;
//			
//			System.out.println("这是第" + j + "个CPU信息: \n" + cpuList[i] + "\n");
//		}
//		System.out.println("—————————————————————————————— CPU MapPerc ————————————————————————————\n\n\n");
//	}
//	
//	public static void main(String[] args) {
//		Sigar sigar = new Sigar();
//		
//		// CPU数量（单位：个）
//		cpuLength(sigar);
//		
//		// CPU的总量（单位：HZ）及CPU的相关信息 
//		cpuInfo(sigar);
//		
//		/** CPU的用户使用量、系统使用剩余量、总的剩余量、总的使用占用量等（单位：100%） **/
//		// 方式一，主要是针对一块CPU的情况
//		cpuPerc(sigar);
//		
//		// 方式二，不管是单块CPU还是多CPU都适用
//		cpuMapPerc(sigar);
//	}
//}
