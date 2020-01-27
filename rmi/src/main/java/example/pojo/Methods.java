package example.pojo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Methods extends Remote{

	public String getInfo() throws RemoteException;
	
}
