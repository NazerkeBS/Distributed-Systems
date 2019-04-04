import java.util.*;
import java.io.*;
import java.net.*;
 
public class Server{
    public static void main(String[] args) throws Exception{
        int port = 12345;
		ServerSocket ss = new ServerSocket(port);
           
        Socket socket = ss.accept();
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        Message readyMessage = (Message) input.readObject();          
        readyMessage.printMessage();

        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ConnectionToRMI object1 = new ConnectionToRMI("localhost", 12346, "StartFromFive");
        ConnectionToRMI object2 = new ConnectionToRMI("localhost", 12346, "StartFromZero");
        Object lock = new Object();
        
        Thread t1 = new MultiThreadedServer(object1, lock, output);
        Thread t2 = new MultiThreadedServer(object2, lock, output);
        
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        
        
        input.close();
        output.close();

	}
}

class MultiThreadedServer extends Thread{

    ConnectionToRMI object;
    Object lock;
    ObjectOutputStream output;

    public MultiThreadedServer(ConnectionToRMI object, Object lock, ObjectOutputStream output){
        this.object = object;
        this.lock = lock;
        this.output = output;
    }

    @Override
    public void run(){
        sendObject();
    }

    public void sendObject(){
        synchronized(lock){
            try{
                output.writeObject(object);
            }catch(Exception e){}
        }
    }

}