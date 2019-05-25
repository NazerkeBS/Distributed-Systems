import java.util.*;
import java.io.*;
import java.net.*;
import java.rmi.registry.*;

public class Client{
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost", 12345);
		
		Hand hand = new Hand();
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		output.writeObject(hand);

		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		Hand opponent = (Hand) input.readObject();

		System.out.println("Your hand: " + hand.getHand());
		System.out.println("Opponent's hand: " + opponent.getHand());

		//connect to RMI Winner Checker
		Socket socket1 = new Socket("localhost", 12343);
		Registry registry = LocateRegistry.getRegistry("localhost", 12343);
		DeclareWinnerInterface declareWinner = (DeclareWinnerInterface) registry.lookup("verifyWinner");

		String won = declareWinner.whoWon(hand.getHand(), opponent.getHand());
		System.out.println(won);

	}
}