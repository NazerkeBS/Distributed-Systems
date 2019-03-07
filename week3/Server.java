import java.util.*;
import java.io.*;
import java.net.*;
public class Server{
	public static void main(String[] args) throws Exception{
	        int port = 12345;
		ServerSocket ss = new ServerSocket(port);
        
       
        	Socket socket = ss.accept();
        	System.out.println("accepted");
        	ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

        	Person p1 = (Person) input.readObject();
                Person p2 = (Person) input.readObject();
                p2.setFamilyName(p1.getFamilyName());

                p1.setMessage("Happy Wedding!");
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(p1);
                output.writeObject(p2);


        	System.out.println(p1.getName() + ", " + p2.getFamilyName() + " " + p2.getName());
                


        	input.close();
                output.close();

        	
        

	}
}