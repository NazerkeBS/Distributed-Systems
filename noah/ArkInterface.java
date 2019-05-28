import java.rmi.*;
public interface ArkInterface extends Remote {
	
	public void addAnimal(String s) throws RemoteException;
	public String listAnimals() throws RemoteException;
}