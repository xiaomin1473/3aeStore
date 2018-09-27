package com.ae.couplet.agent;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class disk {
	public static void main(String[] args) throws SigarException {
		Sigar sigar = new Sigar();
		//取硬盘已有的分区及其详细信息（通过sigar.getFileSystemList()来获得FileSystem列表对象，然后对其进行编历
		FileSystem fslist[] = sigar.getFileSystemList(); 
		String dir = System.getProperty("user.home");// 当前用户文件夹路径 
		System.out.println(dir + "   " + fslist.length); 
		for (int i = 0; i < fslist.length; i++) { 
			System.out.println("\n~~~~~~~~~~" + i + "~~~~~~~~~~"); 
		FileSystem fs = fslist[i]; 
		// 分区的盘符名称 
		System.out.println("fs.getDevName() = " + fs.getDevName()); 
		// 分区的盘符名称 
		System.out.println("fs.getDirName() = " + fs.getDirName()); 
		System.out.println("fs.getFlags() = " + fs.getFlags());// 
		// 文件系统类型，比如 FAT32、NTFS 
		System.out.println("fs.getSysTypeName() = " + fs.getSysTypeName()); 
		// 文件系统类型名，比如本地硬盘、光驱、网络文件系统等 
		System.out.println("fs.getTypeName() = " + fs.getTypeName()); 
		// 文件系统类型 
		System.out.println("fs.getType() = " + fs.getType()); 
		FileSystemUsage usage = null; 
		try { 
		    usage = sigar.getFileSystemUsage(fs.getDirName()); 
		} catch (SigarException e) { 
		    if (fs.getType() == 2) 
		        throw e; 
		    continue; 
		} 
		switch (fs.getType()) { 
		case 0: // TYPE_UNKNOWN ：未知 
		    break; 
		case 1: // TYPE_NONE 
		    break; 
		case 2: // TYPE_LOCAL_DISK : 本地硬盘 
		    // 文件系统总大小 
			System.out.println(" Total = " + usage.getTotal() + "KB"); 
		    // 文件系统剩余大小 
			System.out.println(" Free = " + usage.getFree() + "KB"); 
		    // 文件系统可用大小 
			System.out.println(" Avail = " + usage.getAvail() + "KB"); 
		    // 文件系统已经使用量 
			System.out.println(" Used = " + usage.getUsed() + "KB"); 
		    double usePercent = usage.getUsePercent() * 100D; 
		    // 文件系统资源的利用率 
		    System.out.println(" Usage = " + usePercent + "%"); 
		    break; 
		case 3:// TYPE_NETWORK ：网络 
		    break; 
		case 4:// TYPE_RAM_DISK ：闪存 
		    break; 
		case 5:// TYPE_CDROM ：光驱 
		    break; 
		case 6:// TYPE_SWAP ：页面交换 
		    break; 
		} 
		System.out.println(" DiskReads = " + usage.getDiskReads()); 
		System.out.println(" DiskWrites = " + usage.getDiskWrites()); 
		} 
	}
}
