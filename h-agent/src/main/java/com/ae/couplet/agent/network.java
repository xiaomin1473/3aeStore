package com.ae.couplet.agent;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarNotImplementedException;

public class network {
	public static void main(String[] args) throws SigarException {
		Sigar sigar = new Sigar();
		//当前机器的正式域名
		try { 
			System.out.println(InetAddress.getLocalHost().getCanonicalHostName()); 
		} catch (UnknownHostException e) { 
		    try { 
		    	System.out.println(sigar.getFQDN()); 
		    } catch (SigarException ex) { 
		    } finally { 
		        sigar.close(); 
		    } 
		} 
		   
		// 取到当前机器的IP地址 
		String address = null; 
		try { 
		    address = InetAddress.getLocalHost().getHostAddress(); 
		    // 没有出现异常而正常当取到的IP时，如果取到的不是网卡循回地址时就返回 
		    // 否则再通过Sigar工具包中的方法来获取 
		    System.out.println(address); 
		    if (!NetFlags.LOOPBACK_ADDRESS.equals(address)) { 
		    } 
		} catch (UnknownHostException e) { 
		    // hostname not in DNS or /etc/hosts 
		} 
		try { 
		    address = sigar.getNetInterfaceConfig().getAddress(); 
		} catch (SigarException e) { 
		    address = NetFlags.LOOPBACK_ADDRESS; 
		} finally { 
		} 
		System.out.println(address); 
		   
		// 取到当前机器的MAC地址 
		String[] ifaces = sigar.getNetInterfaceList(); 
		String hwaddr = null; 
		for (int i = 0; i < ifaces.length; i++) { 
		    NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]); 
		    if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) 
		            || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0 
		            || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) { 
		        continue; 
		    } 
		    hwaddr = cfg.getHwaddr(); 
		    System.out.println(hwaddr); 
		    // break; 
		} 
		System.out.println(hwaddr != null ? hwaddr : null); 
		   
		// 获取网络流量等信息 
		String ifNames[] = sigar.getNetInterfaceList(); 
		for (int i = 0; i < ifNames.length; i++) { 
		    String name = ifNames[i]; 
		    NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name); 
		    System.out.println("\nname = " + name);// 网络设备名 
		    System.out.println("Address = " + ifconfig.getAddress());// IP地址 
		    System.out.println("Netmask = " + ifconfig.getNetmask());// 子网掩码 
		    if ((ifconfig.getFlags() & 1L) <= 0L) { 
		    	System.out.println("!IFF_UP...skipping getNetInterfaceStat"); 
		        continue; 
		    } 
		    try { 
		        NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name); 
		        System.out.println("RxPackets = " + ifstat.getRxPackets());// 接收的总包裹数 
		        System.out.println("TxPackets = " + ifstat.getTxPackets());// 发送的总包裹数 
		        System.out.println("RxBytes = " + ifstat.getRxBytes());// 接收到的总字节数 
		        System.out.println("TxBytes = " + ifstat.getTxBytes());// 发送的总字节数 
		        System.out.println("RxErrors = " + ifstat.getRxErrors());// 接收到的错误包数 
		        System.out.println("TxErrors = " + ifstat.getTxErrors());// 发送数据包时的错误数 
		        System.out.println("RxDropped = " + ifstat.getRxDropped());// 接收时丢弃的包数 
		        System.out.println("TxDropped = " + ifstat.getTxDropped());// 发送时丢弃的包数 
		    } catch (SigarNotImplementedException e) { 
		    } catch (SigarException e) { 
		    	System.out.println(e.getMessage()); 
		    } 
		} 
		   
		// 一些其他的信息 
		for (int i = 0; i < ifaces.length; i++) { 
		    NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]); 
		    if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) 
		            || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0 
		            || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) { 
		        continue; 
		    } 
		    System.out.println("cfg.getAddress() = " + cfg.getAddress());// IP地址 
		    System.out.println("cfg.getBroadcast() = " + cfg.getBroadcast());// 网关广播地址 
		    System.out.println("cfg.getHwaddr() = " + cfg.getHwaddr());// 网卡MAC地址 
		    System.out.println("cfg.getNetmask() = " + cfg.getNetmask());// 子网掩码 
		    System.out.println("cfg.getDescription() = " + cfg.getDescription());// 网卡描述信息 
		    System.out.println("cfg.getType() = " + cfg.getType());// 
		    System.out.println("cfg.getDestination() = " + cfg.getDestination()); 
		    System.out.println("cfg.getFlags() = " + cfg.getFlags());// 
		    System.out.println("cfg.getMetric() = " + cfg.getMetric()); 
		    System.out.println("cfg.getMtu() = " + cfg.getMtu()); 
		    System.out.println("cfg.getName() = " + cfg.getName()); 
		}
	}
}
