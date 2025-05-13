package raul.ip.mp9_uf3_a01.config;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import raul.ip.mp9_uf3_a01.domain.Llibre;

public class SocketUtils {

    public static void sendBook(Socket socket, Llibre book) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(book);
        oos.flush();
    }

    public static Llibre receiveBook(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return (Llibre) ois.readObject();
    }
}
