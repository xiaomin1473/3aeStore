package store.ae.server.couplet.info;
//package com.ae.couplet.server.info;
//
//import org.hyperic.sigar.FileSystem;
//import org.hyperic.sigar.FileSystemUsage;
//import org.hyperic.sigar.Sigar;
//import org.hyperic.sigar.SigarException;
//
//public class disk {
//	private static void diskMain(Sigar sigar) throws SigarException {
//		//取硬盘已有的分区及其详细信息（通过sigar.getFileSystemList()来获得FileSystem列表对象，然后对其进行编历
//		FileSystem fslist[] = sigar.getFileSystemList();
//		
//		// 当前用户文件夹路径 
//		String dir = System.getProperty("user.home");
//		System.out.println("用户目录： " + dir + "   磁盘分区数量：" + fslist.length + "\n");
//		
//		for (int i = 0; i < fslist.length; i++) {
//			String[] diskName = {"C","D","E","F"};
//			System.out.println("——————————————————————————— " + diskName[i] + "盘 ———————————————————————————");
//			FileSystem fs = fslist[i]; 
//			// 分区的盘符名称 
//			System.out.println("盘符： " + fs.getDevName()); 
//			// 分区的盘符名称 
//			System.out.println("盘符： " + fs.getDirName());
//			//
//			System.out.println("fs.getFlags() = " + fs.getFlags()); 
//			// 文件系统类型，比如 FAT32、NTFS 
//			System.out.println("文件系统格式： " + fs.getSysTypeName()); 
//			// 文件系统类型名，比如本地硬盘、光驱、网络文件系统等 
//			System.out.println("文件系统类型名： " + fs.getTypeName()); 
//			// 文件系统类型 
//			System.out.println("文件系统类型： " + fs.getType()); 
//			FileSystemUsage usage = null; 
//			try { 
//			    usage = sigar.getFileSystemUsage(fs.getDirName()); 
//			} catch (SigarException e) { 
//			    if (fs.getType() == 2) 
//			        throw e; 
//			    continue; 
//			} 
//			switch (fs.getType()) { 
//				case 0: // TYPE_UNKNOWN ：未知 
//				    break; 
//				case 1: // TYPE_NONE 
//				    break; 
//				case 2: 
//					// TYPE_LOCAL_DISK : 本地硬盘
//					System.out.println("文件系统类型：本地磁盘");
//				    // 文件系统总大小 
//					System.out.println(" Total = " + usage.getTotal()/1024/1024 + "GB");
//					System.out.println(" Total = " + usage.getTotal()/1024 + "MB");
//					// System.out.println(" Total = " + usage.getTotal() + "KB");
//					System.out.println("");
//				    // 文件系统剩余大小 
//					System.out.println(" Free = " + usage.getFree()/1024/1024 + "GB");
//					System.out.println(" Free = " + usage.getFree()/1024 + "MB");
//					// System.out.println(" Free = " + usage.getFree() + "KB");
//					System.out.println("");
//					
//				    // 文件系统可用大小
//					System.out.println(" Avail = " + usage.getAvail()/1024/1024 + "GB");
//					System.out.println(" Avail = " + usage.getAvail()/1024 + "MB");
//					// System.out.println(" Avail = " + usage.getAvail() + "KB");
//					System.out.println("");
//					
//				    // 文件系统已经使用量
//					System.out.println(" Used = " + usage.getUsed()/1024/1024 + "GB");
//					System.out.println(" Used = " + usage.getUsed()/1024 + "MB");
//					// System.out.println(" Used = " + usage.getUsed() + "KB");
//					System.out.println("");
//					
//				    double usePercent = usage.getUsePercent() * 100D; 
//				    // 文件系统资源的利用率 
//				    System.out.println(" Usage = " + usePercent + "%"); 
//				    break; 
//				case 3:// TYPE_NETWORK ：网络 
//				    break; 
//				case 4:// TYPE_RAM_DISK ：闪存 
//				    break; 
//				case 5:// TYPE_CDROM ：光驱 
//				    break; 
//				case 6:// TYPE_SWAP ：页面交换 
//				    break; 
//			}
//			
//			// 读取
//			System.out.println(" DiskReads = " + usage.getDiskReads()/1024 + "MB");
//			// System.out.println(" DiskReads = " + usage.getDiskReads() + "KB");
//			
//			// 写入
//			System.out.println(" DiskWrites = " + usage.getDiskWrites()/1024 + "MB");
//			// System.out.println(" DiskWrites = " + usage.getDiskWrites() + "KB");
//			System.out.println("——————————————————————————— " + diskName[i] + "盘 ———————————————————————————\n\n\n");
//		} 
//	}
//
//	public static void main(String[] args) throws SigarException {
//		Sigar sigar = new Sigar();
//		
//		diskMain(sigar);
//	}
//
//}
