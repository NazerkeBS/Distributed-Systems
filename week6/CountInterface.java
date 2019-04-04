import java.rmi.*;

public interface CountInterface extends Remote{
	int countMeIn() throws RemoteException;
	int dontCountMe() throws RemoteException;
}