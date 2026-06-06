import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;

public class Server {
    public static void main(String[] args) {
        System.out.println(">>> Server online. Waiting for client data...");

        try (ServerSocket serverSocket = new ServerSocket(5005);
             Socket socket = serverSocket.accept();
             DataInputStream in = new DataInputStream(socket.getInputStream())) {

            int id = in.readInt();
            String name = in.readUTF();
            Integer[] marks = { in.readInt(), in.readInt(), in.readInt() };

            String[] namesArray = { name };
            HashMap<Integer, Integer[]> marksMap = new HashMap<>();
            marksMap.put(id, marks);

            System.out.println("\n================ RECEIVED RECORDS ================");
            System.out.println("Names Array Content : " + Arrays.toString(namesArray));
            System.out.println("Marks Map Container : ID " + id + " -> Marks " + Arrays.toString(marksMap.get(id)));
            System.out.println("==================================================");

        } catch (Exception e) {
            System.out.println("Server Operation Error: " + e.getMessage());
        }
    }
}
