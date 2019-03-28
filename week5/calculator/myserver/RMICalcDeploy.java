import java.rmi.registry.*;

public class RMICalcDeploy{
	public static void main(String[] args) throws Exception{
		final int PORT = 12345;

		Registry registry = LocateRegistry.createRegistry(PORT);
		//registry.rebind("rmiAdd", new FourCalculation());
		registry.rebind("rmiAddFive", new FourCalculation(5));	
	}

}
