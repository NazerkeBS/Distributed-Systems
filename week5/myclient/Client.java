import java.rmi.registry.*;

public class Client{
	public static void main(String[] args) throws Exception{

		String host ="localhost";
		int port = 12345;
		String serviceName = "rmiAppendGuy";
		String text  = "potato";

		Registry registry = LocateRegistry.getRegistry(host, port);

		String[] registries = registry.list();
		for(String r : registries){
			System.out.println(r);
		}

		AppendTextInterface appendText = (AppendTextInterface) registry.lookup(serviceName);
		String response = appendText.append(text);
		System.out.println(response);
		
	}
}
