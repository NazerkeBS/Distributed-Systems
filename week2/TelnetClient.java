import java.util.*;
import java.net.*;
import java.io.*;
/*
  args[0] -> machine name
  args[1] -> port number
*/


public class TelnetClient{
	public static void main(String[] args) throws Exception{
		String machine = args[0];
		int port = Integer.parseInt(args[1]);

		try(
			
			Socket socket = new Socket(machine, port);
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			Scanner sc = new Scanner(socket.getInputStream());
			
			Scanner scanner = new Scanner(System.in);
			)
		{
            Thread writeToServer = new Thread(()->{
            	while(scanner.hasNextLine()){
            		String text = scanner.nextLine();
            		pw.println(text);
            		pw.flush();
            	}
            });

            Thread getFromServer = new Thread(() -> {
            	while(sc.hasNextLine()){
            		String message = sc.nextLine();
            		System.out.println(message);
            	}
            });

            writeToServer.start();
            getFromServer.start();

            writeToServer.join();
            getFromServer.join();
		}

	}
}