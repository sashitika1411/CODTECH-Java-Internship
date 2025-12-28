import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    static Set<ClientHandler> clients = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Server started...");

        try {
            ServerSocket serverSocket = new ServerSocket(1234);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);
                client.start();
            }

        } catch (IOException e) {
            System.out.println("Server error");
        }
    }

    static class ClientHandler extends Thread {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Client error");
            }
        }

        public void run() {
            String msg;
            try {
                while ((msg = in.readLine()) != null) {
                    for (ClientHandler c : clients) {
                        c.out.println(msg);
                    }
                }
            } catch (IOException e) {
                System.out.println("Client disconnected");
            }
        }
    }
}
