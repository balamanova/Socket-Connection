package chatroom;

import calculator.Calculation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatroomServer {
    
    

    public static void main(String[] args) {
         try {
            ServerSocket server = new ServerSocket(5555);
            ServerWriterManager writerManager = new ServerWriterManager();
            while (true) {
                Socket client = server.accept();
                BufferedReader incoming = new BufferedReader(new InputStreamReader(client.getInputStream()));
               
                ServerReaderThread servReadThread = new ServerReaderThread(client, incoming, writerManager);
                servReadThread.start();
                
                System.out.println("I`m connected with server");
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
