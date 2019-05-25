import java.util.*;
import java.io.*;
import java.net.*;

public class Server{
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(12345);

		Socket socket = serverSocket.accept();

		//server received an order
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		Order order = (Order) input.readObject();
		order.receiveOrder();

		//server sends back the order
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		output.writeObject(order);

		/*
		If the server was multithreaded, I would place a lock in the receiveOrder() method because there might be the case two threads 
		is going to change the value of received boolean variable simultaneously. One solution would be write a keyword synchronized in 
		the method definition or a synchronized keyword. Even it is possible to create an object call lock:
		Object lock = new Object();
		(lock){
			received = true;
		}
		Thus only one thread can enter into this critical section to modify the variable
		*/


	}

}