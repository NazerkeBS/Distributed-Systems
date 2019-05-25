import java.rmi.registry.*;

public class RMIWinnerChecker{
	public static void main(String[] args) throws Exception{
		
		final int PORT = 12343;

		Registry registry = LocateRegistry.createRegistry(PORT);
		registry.rebind("verifyWinner", new DeclareWinner());
	}
}