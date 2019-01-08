package calculator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        ServerSocket server = new ServerSocket(5555);
        DataInputStream in = null;
        BufferedReader reader;
        PrintWriter out;

        while (true) {        
            Socket client = server.accept();       
            try {            
                BufferedReader incoming = new BufferedReader(new InputStreamReader(client.getInputStream()));            
                PrintWriter send = new PrintWriter(client.getOutputStream());            
                String inputString = incoming.readLine();        
                String[] parts = inputString.split(",");
                
                Calculation calc = new Calculation(parts[0], parts[1], parts[2]);
                calc.compute();
                         
                send.println(calc.getResult());            
                send.flush();            
                client.close();        
            } catch (Exception e) { 
                System.out.println("Exception" + e);
            } }
    }
}
