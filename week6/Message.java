import java.io.*;

public class Message implements Serializable  {
	
	String msg;
	

	public Message(String msg){
		this.msg = msg;
	}

	public String getMessage(){
		return this.msg;
	} 

	public void printMessage(){
		System.out.println(msg);
	}
}