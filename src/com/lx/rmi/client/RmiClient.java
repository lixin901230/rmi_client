package com.lx.rmi.client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.lx.rmi.service.IRmiService;

public class RmiClient {

	public static void main(String[] args) {
		
		try {
			
			// 在RMI服务注册表中查找名称为rmiService的对象，并调用其上的方法
			//调用方式1：
			IRmiService rmiService = (IRmiService) Naming.lookup("rmi://localhost:1099/rmiService");
			String sayHello = rmiService.sayHello(" This is RMI service, by Naming get remote service interface！");
			System.out.println(sayHello);
			
			// 调用方式2：
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			IRmiService rmiService2 = (IRmiService) registry.lookup("rmiService");
			String sayHello2 = rmiService2.sayHello(" This is RMI service, by Registry get remote service interface！");
			System.out.println(sayHello2);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
