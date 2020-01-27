package example.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import example.pojo.Methods;
import example.pojo.MethodsImpl;

public class RmiServer {
	
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(1099);
        Methods obj = new MethodsImpl();
        Naming.rebind("server1", obj);
//        Naming.rebind("rmi://localhost:1099/server1", obj);		same as above
        System.out.println("RMI Server is ready on port:1099");
    }

}
