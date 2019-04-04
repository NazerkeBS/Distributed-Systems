import java.util.*;
import java.io.*;
import java.net.*;
import java.rmi.registry.*;


public class Client {
	public static void main(String[] args) throws Exception{
		String machine = "localhost";
		int port = 12345;
		
		Socket socket = new Socket(machine, port);
	
		// send 'ready' message to the server listening on 12345
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		Message readyMessage = new Message("ready");
		output.writeObject(readyMessage);

		// read two objects from the server on port 12345 at localhost
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		ConnectionToRMI obj1 = (ConnectionToRMI) input.readObject();          
		ConnectionToRMI obj2 = (ConnectionToRMI) input.readObject();          

		// get registry from the server listening on 12346 
		Registry registry = LocateRegistry.getRegistry(obj1.getURL(), obj1.getPort());        

		CountInterface count = (CountInterface) registry.lookup(obj1.getServiceName());
		int response = count.countMeIn();
		System.out.println(response);

		CountInterface dontCount = (CountInterface) registry.lookup(obj2.getServiceName());
		int response2 = dontCount.dontCountMe();
		System.out.println(response2);


		output.close();
		input.close();

	}

}