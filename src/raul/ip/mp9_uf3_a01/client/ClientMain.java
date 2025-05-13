package raul.ip.mp9_uf3_a01.client;

import java.io.IOException;
import java.net.UnknownHostException;
import raul.ip.mp9_uf3_a01.domain.Llibre;

public class ClientMain {
    public static void main(String[] args) {
        try {
            ConnexioClient client = new ConnexioClient("localhost", 5555);
            Llibre libro = new Llibre("50 sombras de Raul", "Jouman Ip Richarte");
            Llibre libro1 = new Llibre("Kamasutra", "Raul Ip Richarte");
            client.transmetre(libro);
            client.transmetre(libro1);
        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
