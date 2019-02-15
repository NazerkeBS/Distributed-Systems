/* 
 * By:  Nazerke S.
 */

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.lang.*;
import java.util.LinkedList;
import java.util.Collections;

public class Main{

	public static void main(String[] args){
		printName("Nazerke");
		
		System.out.println(evaluatePolishNotation(args));
		//replaceConsecutive(args);
		//replaceAllOccurrences(args[0], args[1], args[2]);
		//printPascalTriangle(Integer.parseInt(args[0]));

	}
	/* print args in order*/
	private static void printArgs(String[] strs){
		int cnt = 0;
		for(String s : strs){
			System.out.println(cnt + ". " + s);
			cnt++;
		}
		System.out.println("Number of command line args: " + cnt);	
	}

	/* task 1 */
	private static void printName(String name){
		System.out.println("My name is " + name);
	}
	
	/*print only duplicates*/
	private static void printReplicas(String[] strs){
		int c = 1;
		Map<String, Integer> map = new HashMap<>();
		for(int i =0; i<strs.length; i++){
			if(map.containsKey(strs[i])){
				map.put(strs[i], map.get(strs[i])+1);
			}
			map.put(strs[i], c);
		}
		
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair =  (Map.Entry)it.next();
			if((int) pair.getValue() > 1){
				System.out.println(pair.getKey());
			}
		}	
	}
	
	/* Sum & Print only even numbers & Sort strings & Sort ints */
	private static void sumPrintEvenNumsSort(String[] strs, int len){
		int[] arr = new int[len];
		/*sum*/
		int sum = 0;
		int j = 0;
		for(String s : strs){
			int num = Integer.parseInt(s);
			if(num % 2 == 0){
				System.out.print("Even numbers: " + num + " ");
			}
			sum += num;
			arr[j] = num;
			j++;
		}
		System.out.println();
		System.out.println("Sum: " + sum);
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
		Arrays.sort(strs);
	}


	/*Fibonacci Recursively*/
	private static int fibRec(int n){
		if(n == 0 || n == 1){
			return 1;
		}
		return fibRec(n-1) + fibRec(n-2);
	}
	
	/*Fibonacci Iteratively*/
	private static int fibIt(int n){
		if(n == 0 || n == 1){
			return 1;
		}
		int curr = 1;
		int prev = 0;
		for(int i=2; i<n; i++){
			int temp = prev;
			prev = curr;
			curr = curr + temp;
		}
		return curr;
	}
	
	/*Fibonacci nums store in array*/
	private static List<Integer> toArray(int n){
		List<Integer> result = new ArrayList<>();
		if(n == 0 || n == 1){
			return new ArrayList<>(1);
		}
		int curr = 1;
		int prev = 0;
		for(int i=2; i<n; i++){
			int temp = prev;
			result.add(curr);
			prev = curr;
			curr = curr + temp;
		}
		return result;
	}
	
	/*print all divisors of a number*/
	private static void printDivisors(int n){
		for(int i=0; i<n; i++){
			if(n % i == 0){
				System.out.println(i);
			}
		}
	}
	
	
	
	/*evaluate polish notation*/
	private static int evaluatePolishNotation(String[] strs){
		List<String> operations = new LinkedList<>();
		List<String> nums = new ArrayList<>();
		int result;

		for(int i= strs.length - 1; i>=0; i--){
			if(strs[i].equals("+") ||  strs[i].equals("-") || strs[i].equals("*") || strs[i].equals("/")){
				operations.add(strs[i]);
			}else{
				nums.add((strs[i]));
			}
		}
		
		Collections.reverse(operations);
		
		List<String> list = new ArrayList<>();

		for(int i=0; i<nums.size(); i++){
			list.add(nums.get(i));
			if(i<operations.size()){
				list.add(operations.get(i));
			}
		}
		int i = 0;
		int j = 2;
		int op = 1;
		result = Integer.parseInt(list.get(i));
		while(j < list.size()){
			if(list.get(op).equals("+")){
				result =  result + Integer.parseInt(list.get(j));
				j =  j + 2;
				op = op + 2;
			}
			else if(list.get(op).equals("-")){
				result =  result - Integer.parseInt(list.get(j));
				j =  j + 2;
				op = op + 2;
			}else if(list.get(op).equals("*")){
				result =  result * Integer.parseInt(list.get(j));
				j =  j + 2;
				op = op + 2;
			}else if(list.get(op).equals("/")){
				result =  result / Integer.parseInt(list.get(j));
				j =  j + 2;
				op = op + 2;
			}
		}
		return result;
	}
	
	/*reverse string array */
	private static void reverse(String[] strs){
		for(int i=strs.length-1; i>= 0; i--){
			System.out.println(strs[i]);
		}
	}

	/* Coordinates */
	private static void coordinates(String[] args){
		Coordinate c1 = new Coordinate(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		Coordinate c2 = new Coordinate(Integer.parseInt(args[2]),Integer.parseInt(args[3]));
		if(c1.getDistanceOrigin() > c2.getDistanceOrigin()){
			System.out.println(c1.getPoints());
		}else{
			System.out.println(c2.getPoints());
		}
	}
	
	/* replace all consecutive a's with a single a*/
	private static void replaceConsecutive(String[] strs){
		for(String str : strs){
			String temp = str.replaceFirst("a", "1");
			String s = temp.replace("a", "");
			String result = s.replaceFirst("1", "a");
			System.out.println(result);
		}
	}

	/*replace all occurrences*/
	private static void replaceAllOccurrences(String txt, String oldChar, String newChar){
		String result = txt.replace(oldChar, newChar);
		System.out.println(result);
	}
	
	/*print the first n lines of pascal triangle*/
	private static void printPascalTriangle(int numRows){
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<numRows;i++){
			int number = 1;
			List<Integer> list = new ArrayList<>();
			for(int j=0; j<=i; j++){
				System.out.print( number + " ");
				number = number*(i-j)/(j+1);
			}
			System.out.println();
		}

	}	
}