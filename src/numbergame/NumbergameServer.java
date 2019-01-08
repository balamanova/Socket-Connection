package numbergame;

import calculator.Calculation;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NumbergameServer {

    public static void main(String[] args) throws IOException {
       
        ServerSocket server= new ServerSocket(5555);
        Socket client= server.accept();
        Socket client2= server.accept();
        
        DataInputStream in = null;
        BufferedReader reader;
        PrintWriter out;

        while (true) {
              
            try {
                BufferedReader incoming = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter send = new PrintWriter(client.getOutputStream());
                send.println("1");
                send.flush();
                String inputString = incoming.readLine();
                System.out.println("Get Input");
                send.flush();
                
                client.close();
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }
    }
}
