package chatroom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerWriterManager {
    private final Map<String, PrintWriter> writerMap = new HashMap<>();  
        
    public synchronized void addUser(String username, Socket socket) throws FileNotFoundException, IOException {
        PrintWriter newUser = new PrintWriter(socket.getOutputStream());
        writerMap.put(username, newUser);
        newUser.println("I`m connected");
        newUser.flush();
        
    }
    

    public synchronized void removeUser(String username, Socket socket) throws IOException {
        PrintWriter newUser = new PrintWriter(socket.getOutputStream());
        writerMap.remove(socket, username);
    
    }

    public synchronized void addMessage(String message, String username) throws FileNotFoundException {
        System.out.println("In addMessage method");
       for (Map.Entry<String, PrintWriter> entry : writerMap.entrySet()) {
            String key = entry.getKey();
            PrintWriter value = entry.getValue();
            value.println("\n " + username + "\n: " + message);
            System.out.println("Username: " + username );
            value.flush();
       }
    }

}
