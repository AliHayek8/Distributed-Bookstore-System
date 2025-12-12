import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 2001);
            BookstoreInterface stub = (BookstoreInterface) registry.lookup("BookstoreServer");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter book title:");
            String title = sc.nextLine();
            System.out.println("Enter user name:");
            String user = sc.nextLine();

            String result = stub.purchaseBook(title,user);
            System.out.println(result);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}