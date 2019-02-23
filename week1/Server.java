import java.net.*;
import java.util.*;
import java.io.*;

public class Server{

	private static int clientCounter = 0;
	private static int internalCounter = 0;
	private static Set<Socket> set = new HashSet<>();
	private static Set<String> clientNames = new HashSet<>();
	
	public static void main(String[] args) throws Exception{
	    ServerSocket ssocket = new ServerSocket(12345);
	    int n = Integer.parseInt(args[0]);
	    while(set.size()<n){
	    	set.add(ssocket.accept());
	    }
	    
	    
	    
		for(Socket socket : set){
	    		Scanner scanner = new Scanner(socket.getInputStream());
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				taskSixI(scanner);

	    }
	    for(Socket socket : set){
	    	PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
	    	broadcast(printWriter);
	    }

	}
	protected static void taskOne(PrintWriter printWriter, Scanner scanner){
		String text = "Salem Alem! ";
		String n = scanner.nextLine();
		String result = text;
		for(int i=1; i<Integer.parseInt(n); i++){
			result += text;
		}
		printWriter.println(result);
		printWriter.flush();	
	}

	protected static void taskTwo(PrintWriter printWriter, Scanner scanner){
		String result ="";
		String data = scanner.nextLine();
		for(int i=0; i<data.length(); i++){
			if(Character.isDigit(data.charAt(i))){
				int f = 2*(data.charAt(i)-'0') + 1;
				result += f + " ";
			}
		}
		printWriter.println(result);
		printWriter.flush();
	}

	protected static void taskThree(PrintWriter printWriter, Scanner scanner) throws IOException{
		String fileName = scanner.nextLine();
		System.out.println(fileName);
		File file  = new File(fileName);
		if(!file.exists()){
			printWriter.println("NOT FOUND");
			printWriter.flush();
		}else{
			int cnt = 0;
			Scanner fileScanner  = new Scanner(file);
			while(fileScanner.hasNextLine()){
				String content = fileScanner.nextLine();
				cnt++;
			}
			String result  = "" + cnt;
			printWriter.println(result);
			printWriter.flush();
		}
	}

	protected static void taskFour(PrintWriter printWriter){
		clientCounter++;
		printWriter.println(clientCounter);
	}

	protected static void taskFive(PrintWriter printWriter, Scanner scanner){
		internalCounter = 0;
		String data = scanner.nextLine();
		String[] nums = data.split(",");
		for(int i=0; i<nums.length;i++){
			int n = Integer.parseInt(nums[i]);
			internalCounter += n;
		}
		printWriter.println(internalCounter);
		printWriter.flush(); 
	}

	private static void taskSix(List<Socket> list) throws Exception{
		Socket socketTwo = list.get(1);
		Socket socketOne = list.get(0);
		Scanner scannerTwo = new Scanner(socketTwo.getInputStream());
		PrintWriter printWriterTwo = new PrintWriter(socketTwo.getOutputStream());
		
		Scanner scannerOne = new Scanner(socketOne.getInputStream());
		PrintWriter printWriterOne = new PrintWriter(socketOne.getOutputStream());
			String msg = scannerOne.nextLine();
			printWriterTwo.println(msg);
			String msgTwo = scannerTwo.nextLine();
			printWriterOne.println(msgTwo);	
		
	}

	protected static void taskSixI( Scanner scanner){
		String name = scanner.nextLine();
		clientNames.add(name);
	}
	protected static void broadcast(PrintWriter printWriter){
		String result = "";
		for(String name : clientNames){
			result += name + " ";
		}
		printWriter.println(result);
		printWriter.flush();
	}

}