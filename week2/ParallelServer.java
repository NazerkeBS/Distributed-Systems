import java.util.*;
import java.io.*;
import java.net.*;

public class ParallelServer{
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

		
			Thread t1 = new Thread(() -> {
				try{
					sendMessage(sc1, pw2);
				}catch(Exception e){}
			});

			Thread t2 = new Thread(() -> {
				try{sendMessage(sc2, pw1);} catch(Exception e){}
			});

			t1.start();
			t2.start();

			t1.join();
			t2.join();

		
	}

	private static void sendMessage(Scanner sc, PrintWriter pw)throws Exception{
		while(sc.hasNextLine()){
			String msg = sc.nextLine();
			pw.println(msg);
			pw.flush();
		}

	}
}