package chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class ClientThread extends Thread {

    BufferedReader reader;
    JTextArea messages;
    Socket socket;
    PrintWriter writer;
    String username;

    public ClientThread(Socket socket, JTextArea messages) {
        this.messages = messages;
        this.socket = socket;
    }

    @Override
    public void run() {
        String stream;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (!this.isInterrupted()) {
            try {
                while ((stream = reader.readLine()) != null) {
                    
                    messages.append(stream + "\n");
                    System.out.println(stream);

                }
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
