import java.net.*;
import java.io.*;
import java.util.*;

public class Client{
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 12345);

		Scanner sc = new Scanner(socket.getInputStream());
		PrintWriter pw = new PrintWriter(socket.getOutputStream());

	    Scanner scanner = new Scanner(System.in);
	    
	    while(true){
			String message = scanner.nextLine();
        
        	pw.println(message);
        	pw.flush();

        	String reply = sc.nextLine();
        
       	    System.out.println(reply);
	    }
       

	}

}