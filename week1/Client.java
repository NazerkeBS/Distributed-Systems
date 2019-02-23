import java.net.*;
import java.util.*;
import java.io.*;

public class Client{
	public static void main(String[] args) throws Exception{
		try(Socket socket = new Socket("localhost", 12345); 
			Scanner scanner = new Scanner(socket.getInputStream());
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			){
				taskSixI(printWriter, scanner, args[0]);
		}

	}

	protected static void taskOne(PrintWriter printWriter, Scanner scanner, String data){
			printWriter.println(data);
			printWriter.flush();
			String reply = scanner.nextLine();
			System.out.println(reply);
	}

	protected static void taskTwo(PrintWriter printWriter, Scanner scanner) throws IOException{
		Scanner fileScanner = new Scanner(new File("in.txt"));
		String data = "";
		while(fileScanner.hasNext()){
			int num = fileScanner.nextInt();
			data += num;
		}
		data = data + "end";
		printWriter.println(data);
        printWriter.flush();
		String reply = scanner.nextLine();
		System.out.println(reply);
	}

	protected static void taskThree(PrintWriter printWriter, Scanner scanner){
		String data = "in.txt";
		printWriter.println(data);
		printWriter.flush();

		String reply = scanner.nextLine();
		System.out.println(reply);
	}
	protected static void taskFour(Scanner scanner){
		int reply = scanner.nextInt();
		System.out.println(reply);
	}

	protected static void taskFive(PrintWriter printWriter, Scanner scanner, String[] arr){
		String data  = "";
		for(int i=0; i<arr.length-1; i++){
			data += arr[i] + ",";
		}
		printWriter.println(data);
		printWriter.flush();

		int reply = scanner.nextInt();
		System.out.println(reply); 
	}

	private static void taskSix(PrintWriter printWriter, Scanner scanner){
		Scanner inputScanner  = new Scanner(System.in);

		while(true){
			System.out.println("Enter: ");
			String input  = inputScanner.nextLine();
			printWriter.println(input);
			printWriter.flush();

			String reply = scanner.nextLine();
			System.out.println(reply);
		}

	} 

	protected static void taskSixI(PrintWriter printWriter, Scanner scanner, String name){
		printWriter.println(name);
		printWriter.flush();

		String reply = scanner.nextLine();
		System.out.println(reply);
	}
}