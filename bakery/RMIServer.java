import java.rmi.registry.*;

/*
RMI methods are already multhithreaded because it automatically will 
execute each client in a separate thread. So there is only one instance of RMI server and multiple clients connecting to it. 
Note that shared resource access must be synchronized to prevent race condition.
*/
public class RMIServer{
	public static void main(String[] args) throws Exception{
		
		final int PORT = 12343;

		Registry registry = LocateRegistry.createRegistry(PORT);
		registry.rebind("GenerateOrders", new OrderProducer());
	}
}