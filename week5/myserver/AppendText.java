import java.rmi.*;

public class AppendText extends java.rmi.server.UnicastRemoteObject implements AppendTextInterface{

	String text;

	public AppendText(String text) throws RemoteException{
		this.text = text;
	}

    /*append()*/
	public String append(String sentText) throws RemoteException{
		return sentText + text;
	}

}
