package example.pojo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MethodsImpl extends UnicastRemoteObject implements Methods{

	private static final long serialVersionUID = 3290388809874724804L;

	public MethodsImpl() throws RemoteException {
		super();
	}

	@Override
	public String getInfo() {
		return "This info obtained with RMI";
	}



}
