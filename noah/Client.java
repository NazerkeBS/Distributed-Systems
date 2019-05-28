import java.util.*;
import java.io.*;
import java.net.*;
import java.rmi.registry.*;

public class Client{
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost", 12345);
		String animal;
		List<String> result = new ArrayList<>();

		while(true){
			try{

				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				animal = (String) input.readObject();
				System.out.println(animal);
				result.add(animal);

			}catch(Exception e){
				break;
			}
		}

		//connect to RMI Ark
		Socket socket1 = new Socket("localhost", 12343);
		Registry registry = LocateRegistry.getRegistry("localhost", 12343);
		ArkInterface arkAdd = (ArkInterface) registry.lookup("addAnimal");
		for(String r : result){
			arkAdd.addAnimal(r);
		}


		ArkInterface arkList = (ArkInterface) registry.lookup("listAnimals");
		System.out.println("******* RMI: *******" + arkList.listAnimals());
		
	}
}