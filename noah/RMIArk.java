import java.rmi.registry.*;

public class RMIArk {
	public static void main(String[] args) throws Exception{
		Registry registry = LocateRegistry.createRegistry(12343);
		Ark ark = new Ark();
		registry.bind("addAnimal", ark);
		registry.bind("listAnimals", ark);

	}
	
	/*
		RMI methods are already multhithreaded because it automatically will 
		execute each client in a separate thread. So there is only one instance of RMI server and multiple clients connecting to it. 	
		Note that shared resource access must be synchronized to prevent race condition.
	*/
}