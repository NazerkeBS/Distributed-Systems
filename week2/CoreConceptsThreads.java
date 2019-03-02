/*
 * There are 2 basic ways of creating threads in Java.
 * 1. Extend Thread class
 * 2. Implement Runnable interface and pass it to the Thread constructor
*/

class Runner extends Thread{

	public void run(){
		for(int i=0; i<10; i++){
			System.out.println(i);
			if(Thread.currentThread().isInterrupted()){
				System.out.println("interrupted...");
			}
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
	}
}

class Runner2 implements Runnable{
	public void run(){
		for(int i=0; i<10; i++){
			System.out.println(i);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
	}
}

public class CoreConceptsThreads {

	public static void main(String[] args) throws Exception {
		Runner runner  = new Runner();
		runner.start();
		runner.interrupt();
		Thread thread = new Thread(new Runner2());
		thread.start();

	}
}



