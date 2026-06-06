import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Connecting to server...");
        
        try (Socket socket = new Socket("localhost", 5005);
             Scanner scanner = new Scanner(System.in);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Marks for 3 subjects (space separated): ");
            int m1 = scanner.nextInt();
            int m2 = scanner.nextInt();
            int m3 = scanner.nextInt();

            out.writeInt(id);
            out.writeUTF(name);
            out.writeInt(m1);
            out.writeInt(m2);
            out.writeInt(m3);
            out.flush();

            System.out.println(">>> Data transmitted successfully!");

        } catch (Exception e) {
            System.out.println("Client Connection Error: " + e.getMessage());
        }
    }
}
