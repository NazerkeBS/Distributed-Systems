import java.util.ArrayList;
import java.rmi.*;

public class Ark extends java.rmi.server.UnicastRemoteObject implements ArkInterface{

  private ArrayList <String> animals;

  public Ark() throws RemoteException{
    animals  = new ArrayList<String>();
  }

  @Override
  public void addAnimal(String s) throws RemoteException{
    animals.add(s);
  }

  @Override
  public String listAnimals() throws RemoteException{
    String s = "";
    for(String a : animals){
      s += a+"\n";
    }
    return s;
  }
}