package raul.ip.mp9_uf3_a01.client;

import java.io.IOException;
import java.net.Socket;
import raul.ip.mp9_uf3_a01.config.SocketUtils;
import raul.ip.mp9_uf3_a01.domain.Llibre;

public class ConnexioClient {
    private String host;
    private int port;

    public ConnexioClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void transmetre(Llibre... books) throws IOException, ClassNotFoundException {
        try (Socket socket = new Socket(host, port)) {
            for (Llibre book : books) {
                SocketUtils.sendBook(socket, book);
                Llibre respuesta = SocketUtils.receiveBook(socket);
                System.out.println("Libros actuales: " + respuesta);
            }
        }
    }
}
