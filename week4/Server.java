import java.util.*;
import java.io.*;
import java.net.*;

public class Server{
	public static void main(String[] args) throws Exception{
		int port = 12345;
		ServerSocket ss = new ServerSocket(port);
    
        	while(true){

					Socket socket = ss.accept();
        			System.out.println("First client is connected: "+ socket);
        			Thread serverThread = new Thread(new ServerThread(socket));
        			serverThread.start();
        			serverThread.join();
        	
        	}

	}
}

class ServerThread implements Runnable{
	Socket socket;
	Scanner sc;
	PrintWriter pw;
	public ServerThread(Socket socket) throws Exception{
		this.socket = socket;
		sc = new Scanner(socket.getInputStream());
		pw = new PrintWriter(socket.getOutputStream());

	}
	public void run(){
		String text;
		while(true){
			while(sc.hasNextLine()){
				text = sc.nextLine();
				System.out.println(text);
			}
		}
	}
}