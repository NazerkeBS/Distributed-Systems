import java.util.*;
import java.io.*;
import java.net.*;
import java.rmi.registry.*;

public class Client{
	public static void main(String[] args) throws Exception{

		//RMI server
		Socket socket = new Socket("localhost", 12343);
		Registry registry = LocateRegistry.getRegistry("localhost", 12343);

		OrderProducerInterface orderProducer = (OrderProducerInterface) registry.lookup("GenerateOrders");
		Order strawberry = orderProducer.newOrder("Strawberry");

		System.out.println(strawberry.toString());

		//Server
		Socket socket1 = new Socket("localhost", 12345);
		//client sends a request of strawberry to the server
		ObjectOutputStream output = new ObjectOutputStream(socket1.getOutputStream());
		output.writeObject(strawberry);
		
		// client gets a response from the server for his order
		ObjectInputStream input = new ObjectInputStream(socket1.getInputStream());
		Order order = (Order) input.readObject();
		System.out.println(order.toString());

		
		 
		
	}
}