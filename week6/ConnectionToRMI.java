import java.io.*;

/*
  This is kind of relay to forward service name and ip address of 
  the server that deploys the CountConnections service
*/

public class ConnectionToRMI implements Serializable{
	
	private String url;
	private int port;
	private String serviceName;

	public ConnectionToRMI(){

	}
	public ConnectionToRMI(String url, int port, String serviceName){
		this.url = url;
		this.port = port;
		this.serviceName =serviceName;
	}

	public String getURL(){
		return this.url;
	}	
	public String getServiceName(){
		return this.serviceName;
	}
	public int getPort(){
		return this.port;
	}

}