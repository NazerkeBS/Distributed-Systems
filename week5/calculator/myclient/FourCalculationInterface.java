import java.rmi.*;

public interface FourCalculationInterface extends Remote {

	float add(float num) throws RemoteException;
	float subtruct(float num) throws RemoteException;
	float multiply(float num) throws RemoteException;
	float divide(float num) throws RemoteException;



}
