import java.util.*;
import java.io.*;
import java.net.*;

import models.*;

public class Server{
	
	public static void main(String[] args) throws Exception{
	
		int port = 12345;
		ServerSocket ss = new ServerSocket(port);

		Board board = new Board();
		int turn=1, w=1;
		
		Socket socket1 = ss.accept();	
		System.out.println(socket1);

	    
	    Message msg1 = new Message("You are Player",1);
		ObjectOutputStream output1 = new ObjectOutputStream(socket1.getOutputStream());
		ObjectInputStream input1 = new ObjectInputStream(socket1.getInputStream());
		output1.writeObject(msg1);

		Socket socket2 = ss.accept();
		System.out.println(socket2);	
	 	Message msg2 = new Message("You are Player",2);
		ObjectOutputStream output2 = new ObjectOutputStream(socket2.getOutputStream());
		ObjectInputStream input2 = new ObjectInputStream(socket2.getInputStream());
		
		output2.writeObject(msg2);
		
		Thread t = new WriteBoard(output1,output2, input1, input2, board, w, turn);
		t.start();
				
	}

}

class WriteBoard extends Thread{
	ObjectOutputStream output1;
	ObjectOutputStream output2;
	ObjectInputStream input1;
	ObjectInputStream input2;
	int w;
	int turn;
	Board board;

	public WriteBoard(ObjectOutputStream output1,ObjectOutputStream output2, ObjectInputStream input1, ObjectInputStream input2, Board board, int w, int turn){
		this.output1 = output1;
		this.output2 = output2;
		this.input1 = input1;
		this.input2 = input2;
		this.board = board;
		this.w = w;
		this.turn = turn;
	}

	public void run(){
		boolean play = true;

		while(play){
			try{
				board.showBoard();
				output1.writeObject(board);
				output2.writeObject(board);
				output1.flush();
				output2.flush();

				if(won(board) == 0){
					Message msgTurn = new Message("\nTurn ",turn);
					Message msgPlayerTurn = new Message("It's turn of Player " , who(w));
					
					output1.writeObject(msgTurn);
					output2.writeObject(msgTurn);
					output1.flush();
					output2.flush();

					output1.writeObject(msgPlayerTurn);
					output2.writeObject(msgPlayerTurn);
					output1.flush();
					output2.flush();

					if(who(w) == 1){
						output1.writeObject(board);
						output1.flush();

						board = (Board) input1.readObject();
						board.showBoard();

						output1.writeObject(board);
						output1.flush();

					}else{

						output2.writeObject(board);
						output2.flush();

						board = (Board) input2.readObject();
						board.showBoard();

						output2.writeObject(board);
						output2.flush();
					}


                     
                     if(board.fullBoard()){
                     	Message full = new Message("Full Board. Draw!",-1);
                     	output1.writeObject(full);
						output2.writeObject(full);
						output1.flush();
						output2.flush();

                     	play = false;
                     }else{
                     	Message message = new Message("Go on...",0);
                     	output1.writeObject(message);
						output2.writeObject(message);
						output1.flush();
						output2.flush();


                     }
                     w++;
                     turn++;
                    
				}else{
					if(won(board) == -1){
						Message won = new Message("Player 1 won!",-1);
						output1.writeObject(won);
						output2.writeObject(won);
						output1.flush();
						output2.flush();


					}else {
						Message won = new Message("Player 2 won!",-1);
						output1.writeObject(won);
						output2.writeObject(won);
						output1.flush();
						output2.flush();

					}
					play = false;

				}

				
			}catch(Exception e){}
		}
	
	}


	/*which player*/
	public static int who(int w){
        if(w%2 == 1)
            return 1;
        else
            return 2;
    }
       
    /*who is  a winner */
    public static int won(Board board){
        if(board.checkLines() == 1)
            return 1;
        if(board.checkColumns() == 1)
            return 1;
        if(board.checkDiagonals() == 1)
            return 1;

        if(board.checkLines() == -1)
            return -1;
        if(board.checkColumns() == -1)
            return -1;
        if(board.checkDiagonals() == -1)
            return -1;

        return 0;
    }
}
