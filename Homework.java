/* 
 * By:  Nazerke S.
 */

import java.util.Scanner;
import java.io.*;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream;

public class Homework{
	
	public static void main(String[] args) throws Exception{
		//Scanner scanner = new Scanner(System.in);
		//sum(scanner);
		//readWriteFile();
		filenamesNums();

	}

	/* 1. Scanner i/o */
	private static void sum(Scanner scanner){
		String num1 = scanner.nextLine();
		String num2 = scanner.nextLine();
		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
		System.out.println(sum);
		String s = scanner.nextLine();
		System.out.println("With whitespaces: " + s.length());
		String ss = s.replaceAll("\\s", "");
		System.out.println("After removing whitespaces: " + ss.length());

	}

	/* 2. PrintWriter & Scanner */
	private static void readWriteFile() throws Exception{
		File file = new File("in.txt");
		Scanner sc = new Scanner(file);
		Stack <String> stack = new Stack<>();
		PrintWriter printWriter = new PrintWriter("out.txt");
		
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			stack.push(s);
		}

		while(!stack.isEmpty()){
			String ss = stack.pop();
			printWriter.write(ss + "\n");
			
		}
		printWriter.close();
	}

	/*3. Filenames & Integers */
	private static void filenamesNums() throws Exception{
		File file = new File("in.txt");
		Scanner sc = new Scanner(file);
		
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();

		while(sc.hasNextLine()){
			String s = sc.next();
			Scanner subscanner = new Scanner(new File(s)) ;
			String ss = subscanner.next();
			
			int min = Integer.parseInt(ss);
			list.add(min);
			set.add(min);
			while(subscanner.hasNext()){
				ss = subscanner.next();
				int num = Integer.parseInt(ss);
				list.add(num);
				set.add(num);
				if(num < min){
					min = num;
				}
				
			}
			System.out.println(min);
			if(list.size() == set.size()){
				System.out.println(s);
			}
			int total = total(list);
			map.put(s, total);
		}
		/*Stream<Map.Entry<String,Integer>> sorted = map.entrySet().stream()
                                                      .sorted(Map.Entry.comparingByValue()); */
		System.out.println(map.toString());
	}

	private static int total(List<Integer> list){
		int result = 0;
		for(int i : list){
			result += i;
		}
		return result;
	}
}