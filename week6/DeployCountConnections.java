import java.rmi.registry.*;
/* 
  This server deploys the Count Connection service 
*/

public class DeployCountConnections{
	public static void main(String[] args) throws Exception{
		final int PORT = 12346;
		Registry registry = LocateRegistry.createRegistry(PORT);
		registry.bind("StartFromFive", new CountConnections(5));
		registry.bind("StartFromZero", new CountConnections());		
	}
}