import java.util.*;
import java.io.*;
import java.net.*;

import models.*;

public class Client{
	public static void main(String[] args)  throws Exception{

		String machine  = "localhost";
		int port = 12345;
		Socket socket = new Socket(machine,port);

		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream output =  new ObjectOutputStream(socket.getOutputStream());

		Message msg = (Message) input.readObject();
		Player player = new Human(msg.getPlayer());


		System.out.println(msg.getMessage());
		if(player.player == 1){
			System.out.println("Your selected cell is gonna be X");
		}else {
			System.out.println("Your selected cell is gonna be 0");

		}

		Thread t = new ThreadWriteToBoard(input, output, player, player.player);
		t.start();
			
	
	}
}

class ThreadWriteToBoard extends Thread{
	private ObjectInputStream input;
	private ObjectOutputStream output;

	private Player player;
	private int turn;

	public ThreadWriteToBoard(ObjectInputStream input,ObjectOutputStream output, Player player, int turn){
		this.input = input;
		this.output = output;
		this.player = player;
		this.turn  = turn;

	}
	public void run() {
		boolean play = true;

		while(play){
		    try{

				Board b = (Board) input.readObject();
				b.showBoard();

				Message msgTurn = (Message) input.readObject();
				System.out.println(msgTurn.getMessage());

				Message msgPlayerTurn = (Message) input.readObject();
				System.out.println(msgPlayerTurn.getMessage());

				b = (Board) input.readObject();
				player.play(b);
				
				output.writeObject(b);
				output.flush();
				
				b = (Board) input.readObject();
				b.showBoard();

				Message message = (Message) input.readObject();
				System.out.println(message.getText());
				if(message.getPlayer() == -1){
					play = false;
					input.close();
					break;
				}


			}catch(Exception e){}
		}

	}
}

