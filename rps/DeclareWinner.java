import java.rmi.*;
import java.util.*;

public class DeclareWinner extends java.rmi.server.UnicastRemoteObject implements DeclareWinnerInterface{
  public DeclareWinner() throws RemoteException{}

  @Override
  public String whoWon(char me, char theOther){
    if(me==theOther){
      return "You draw";
    }
    if((me=='s' && theOther=='p') || (me=='p' && theOther=='r') || (me=='r' && theOther=='s')){
      return "You won";
    }
    return "You lost";
  }
}