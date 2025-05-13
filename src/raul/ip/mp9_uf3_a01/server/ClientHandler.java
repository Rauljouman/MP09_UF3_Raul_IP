package raul.ip.mp9_uf3_a01.server;

import java.io.IOException;
import java.net.Socket;
import raul.ip.mp9_uf3_a01.config.SocketUtils;
import raul.ip.mp9_uf3_a01.domain.Llibre;

public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Llibre book = SocketUtils.receiveBook(socket);
            System.out.println("Recibido del cliente: " + book);
            SocketUtils.sendBook(socket, book);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
