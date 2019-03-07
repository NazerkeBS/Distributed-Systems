import java.util.*;
import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args) throws Exception{
		int port = 12345;
		String computer  = "localhost";

		//Animal animal = new Animal("Cat Joe");
		Person person1 = new Person("Maya", "happy family", "welcome, Naz");
		Person person2 = new Person("John", "happy family", "welcome, Erke");

			Socket socket = new Socket(computer, port);
			//ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.writeObject(person1);
			outputStream.writeObject(person2);
            
			//outputStream.flush();
			
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

        	Person p1 = (Person) input.readObject();
            
            Person p2 = (Person) input.readObject();
            input.close(); 
            outputStream.close();   

			//inputStream.close();
			//socket.close();

			
	}	
}