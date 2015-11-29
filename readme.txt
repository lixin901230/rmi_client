
一：普通RMI 

1.客户断与服务器端 的接口要放在[同名]的包内 
3.接口要extends Remote，接口方法要throws RemoteException；同样接口实现类的相应方法也要throws RemoteException（包括构造方法） 
2.接口实现类要extends UnicastRemoteObject并继承服务接口 

服务端代码： 
    LocateRegistry.createRegistry(1299);
    Naming.bind("rmi://localhost:1299/服务名字", new 实现类() ); 

客户代码： 
	接口 service = (接口)Naming.lookup("rmi://202.114.63.4:1299/服务名字");
或：
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
	接口 service = (接口)registry.lookup("rmiService");

二：Spring RMI: 

从普通ＲＭＩ改编时要注意需要将实现类的extends UnicastRemoteObject去掉，
否则会报错:
［org.springframework.beans.factory.BeanCreationException: 
Error creating bean with name 'refreshService' defined in class path resource [applicationContext.xml]: 
Initialization of bean failed; nested exception is java.rmi.server.ExportException: object already exported］ 

因为UnicastRemoteObject的作用就是生成stub object 