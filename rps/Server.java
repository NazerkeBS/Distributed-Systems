import java.util.*;
import java.io.*;
import java.net.*;
import java.rmi.registry.*;

public class Server{
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(12345);

		Socket socket1 = serverSocket.accept();
		System.out.println("first client is connected. Waiting for the second one");
		Socket socket2 = serverSocket.accept();
		System.out.println("second clinet is connected");

		//Server is reading two Hand objects got from two connected clients
		ObjectInputStream input1 = new ObjectInputStream(socket1.getInputStream());
		Hand hand1 = (Hand) input1.readObject();

		ObjectInputStream input2 = new ObjectInputStream(socket2.getInputStream());
		Hand hand2 = (Hand) input2.readObject();

		// Exchange objects between two clients
		ObjectOutputStream output1 = new ObjectOutputStream(socket1.getOutputStream());
		output1.writeObject(hand2);

		ObjectOutputStream output2 = new ObjectOutputStream(socket2.getOutputStream());
		output2.writeObject(hand1);

		System.out.println("server's job is done");


		
	}
}