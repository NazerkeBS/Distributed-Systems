import java.util.*;
import java.io.*;
import java.net.*;
import java.rmi.registry.*;

public class Server{
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(12345);

		Socket socket1 = serverSocket.accept();
		System.out.println("First client is accepted. Waiting for the second client...");
		Socket socket2 = serverSocket.accept();
		System.out.println("Second client is connected.");

		AnimalDeck animals = new AnimalDeck();
		Object lock = new Object();
		AnimalThread thread1 = new AnimalThread(animals, socket1, lock);
		AnimalThread thread2 = new AnimalThread(animals, socket2, lock);
		
		thread1.start();
		thread2.start();
	
	}
}

class AnimalThread extends Thread{
	
	private AnimalDeck animals;
	private Socket socket;
	private Object lock;

	public AnimalThread (AnimalDeck animals, Socket socket, Object lock) throws Exception{
		this.animals = animals;
		this.socket = socket;
		this.lock = lock;
	}

	public void run(){
		try{
			while(animals.animalsLeft() != 0){	
				sleep(500);
				getAnimal();	
		    }
		}catch(Exception e){}
	}

	/* 
		The lock ensures that only one thread has an access to the critical section. 
		In our case, the critical section is the getting animal from the array. 
	*/
	void getAnimal() throws Exception{
		synchronized (lock){
			if(animals.animalsLeft() != 0){
				String animal = animals.takeTheFirst();
				ObjectOutputStream output = new ObjectOutputStream(this.socket.getOutputStream());
				output.writeObject(animal);
			}
		}
	
	}
	
}