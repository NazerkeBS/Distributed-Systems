import java.util.*;
import java.io.*;
import java.net.*;

public class TelnetClient{
	public static void main(String[] args) throws Exception {
		String machine = args[0];
		int port = Integer.parseInt(args[1]);
		try(
				Socket socket = new Socket(machine, port);
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				Scanner sc = new Scanner(socket.getInputStream());
				

			){
			Thread printerThread = new Thread(new ClientToServerThread(pw));

			Thread writerThread = new Thread(new ServerToClientThread(sc));
			printerThread.start();
			writerThread.start();

			printerThread.join();
			writerThread.join();

        	
		}
	}
}

class ClientToServerThread implements Runnable{
	PrintWriter pw;

	ClientToServerThread(PrintWriter pw){
		this.pw = pw;
	}
	@Override
	public void run(){
		Scanner  scanner = new Scanner(System.in);
		String s;
		while(true){
			while(scanner.hasNextLine()){
        		s = scanner.nextLine();
        		pw.println(s);
        		pw.flush();
        		System.out.println(s);
        	}
		}
	}

}

class ServerToClientThread implements Runnable{
	Scanner sc;
	public ServerToClientThread(Scanner sc){
		this.sc = sc;
	}

	public void run(){
		while(true){
			while(sc.hasNextLine()){
				String str = sc.nextLine();
				System.out.println(str);
			}
		}
	}
}