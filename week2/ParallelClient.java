import java.util.*;
import java.io.*;
import java.net.*;

/* two-client console chat application */
public class ParallelClient{
	public static void main(String[] args) throws Exception{
		Socket client = new Socket("localhost", 12345);

		Scanner sc = new Scanner(client.getInputStream());
		PrintWriter pw = new PrintWriter(client.getOutputStream());
		

		Scanner scanner = new Scanner(System.in);
		

		Thread clientThreadReader = new Thread(() -> {
			communicate(new PrintWriter(System.out), sc);
		});
		Thread clientThreadWriter = new Thread(() -> {
			communicate(pw, scanner);
		});

		
		clientThreadReader.start();
		clientThreadWriter.start();

		
		clientThreadReader.join();
		clientThreadWriter.join();

	}

	private static void communicate(PrintWriter pw, Scanner scanner){
		while(scanner.hasNextLine()){
			String msg = scanner.nextLine();
			pw.println(msg);
			pw.flush();

		}
	}
}