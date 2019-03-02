public class MultiThread  {
	public static void main(String[] args) throws Exception {
		Object lock = new Object();


		Thread t1 = new TextPrintingThread("hello", lock);
		Thread t2 = new TextPrintingThread("world", lock);
		t1.start();
        
		t2.start();
		


	}
}

class TextPrintingThread extends Thread {
    private String text;
    private Object lock;

	public  TextPrintingThread(String text, Object lock){
		this.text = text;
		this.lock = lock;
	}

	@Override
	public void run(){
		for(int i=0; i<10; i++){
			try {
				sleep(1);
			}
			catch(Exception e){
				System.out.println("wrong");
			}
			myPrintLn();
		}

	}

	public void myPrintLn(){
		synchronized(lock){
			for(char c : text.toCharArray()){
			System.out.print(c);
		    }
		}
		
		System.out.println();

	}
}