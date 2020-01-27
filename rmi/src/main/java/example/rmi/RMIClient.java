package example.rmi;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import example.pojo.Methods;

public class RMIClient {

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost");
		Methods obj = (Methods) registry.lookup("server1");
		System.out.println("Received: " + obj.getInfo());
	}

}
