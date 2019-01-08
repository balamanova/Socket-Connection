package chatroom;

import java.io.BufferedReader;
import java.net.Socket;

public class ServerReaderThread extends Thread {

    private final Socket socket;
    private final BufferedReader reader;
    private final ServerWriterManager writerManager;
    private String username = "";

    public ServerReaderThread(Socket socket, BufferedReader reader, ServerWriterManager writerManager) {
        this.socket = socket;
        this.reader = reader;
        this.writerManager = writerManager;
    }

    @Override
    public void run() {
        while (true) {
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

            try {
                data = reader.readLine().split(":");

                if (data[0].equals(chat)) {
                    writerManager.addMessage(data[1], data[2]);
                    System.out.println("Message: " + data[1]);
                } else if (data[0].equals(connect)) {
                    writerManager.addUser(data[1], socket);
                    System.out.println("Im in add method");
                } else if (data[0].equals(disconnect)) {
                    writerManager.removeUser(username, socket);
                }

            } catch (Exception ex) {
                //System.out.println("Occured in ServerREaderThread" + ex);
                ex.printStackTrace();
            }
        }

    }

    private void writeUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
