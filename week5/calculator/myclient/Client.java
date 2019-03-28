import java.rmi.registry.*;

public class Client{
	public static void main(String[] args) throws Exception{

		String host ="localhost";
		int port = 12345;
		String serviceName1 = "rmiAddFive";
		float num = 1;

		Registry registry = LocateRegistry.getRegistry(host, port);

		FourCalculationInterface addNum = (FourCalculationInterface) registry.lookup(serviceName1);
		float response1 = addNum.add(num);
		float response2 = addNum.multiply(response1);
		System.out.println(response2);
		
	}
}
