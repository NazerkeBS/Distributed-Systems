import java.util.concurrent.ThreadLocalRandom;

class Goat extends Thread{
	private int step = 0;
	private int middle;
	private String name;

	public Goat (int middle, String name){
		this.middle = middle;
		this.name = name;
	}

	public void run(){
		while(step != middle){
			int rand = ThreadLocalRandom.current().nextInt(500, 2001);
        	try{
				Thread.sleep(rand);
       		}catch(Exception e){}
        	moveForward();
        	
        	System.out.println(name + "  position at: " + step);
        	
		}

	}

	public synchronized void moveBack(){
		step--;
	}
	public synchronized void moveForward(){
		step++;
	}
	
}

public class Goats{
	public static void main(String[] args) throws Exception{
		int mid = Integer.parseInt(args[0])/2;
		Goat goat1 = new Goat(mid, "worker 1");
		Goat goat2 = new Goat(mid, "worker 2");
		goat1.start();
		goat2.moveBack();
		goat2.start();
		goat1.moveBack();

	}
}