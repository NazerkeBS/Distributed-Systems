import java.util.*;
import java.io.*;
import java.net.*;

/*two-client chat which waits for the other's response*/
public class ChatServer{
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(12345);

		Socket client1 = serverSocket.accept();
		System.out.println("First client is connected: "+ client1);
		Scanner sc1 = new Scanner(client1.getInputStream());
		PrintWriter pw1 = new PrintWriter(client1.getOutputStream());

		Socket client2 = serverSocket.accept();
		System.out.println("Second client is connected: " + client2);
		Scanner sc2 = new Scanner(client2.getInputStream());
		PrintWriter pw2 = new PrintWriter(client2.getOutputStream());

		while(true){
			String message1 = sc1.nextLine();
			pw2.println(message1);
			pw2.flush();

			String message2 = sc2.nextLine();
			pw1.println(message2);
			pw1.flush();
		}


	}
}