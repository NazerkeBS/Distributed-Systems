import java.io.*;

public class Message implements Serializable{
	private String message;
	private int player;

	public Message(String message, int player){
		this.message = message;
		this.player = player;
	}
	public Message(String message){
		this.message = message;
	}

	public String getMessage(){
		return this.message + " " + this.player;
	}
	public int getPlayer(){
		return this.player;
	}
	public String getText(){
		return this.message;
	}
}
