import java.util.*;
import java.io.*;
import java.net.*;

class Server
{
    public static void main(String[] args)
        throws Exception
    {
        int port = 12345;

        try (
            ServerSocket ss = new ServerSocket(port);
            
            Socket s  = ss.accept();
            Scanner sc = new Scanner(s.getInputStream());
            PrintWriter pw = new PrintWriter(s.getOutputStream());


            Socket s2  = ss.accept();
            Scanner sc2 = new Scanner(s2.getInputStream());
            PrintWriter pw2 = new PrintWriter(s2.getOutputStream());
   
        ) {

          String text = sc.nextLine();

          pw.println(text.length());
          pw.flush();

          String text2 = sc2.nextLine();

          pw2.println(text2.length());
          pw2.flush();

        }

    }
}