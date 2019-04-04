import java.rmi.*;
/*
  This class implements the count interface
*/
public class CountConnections extends java.rmi.server.UnicastRemoteObject implements CountInterface{
	int n;

	public CountConnections() throws RemoteException{

	}

	public CountConnections(int n) throws RemoteException{
		this.n = n;
	}
	public int countMeIn() throws RemoteException{
		this.n = this.n + 1;
		return this.n;
	}
	public int dontCountMe() throws RemoteException{
		return this.n;
	}
}