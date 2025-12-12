import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class BookstoreServer implements BookstoreInterface {

    public BookstoreServer() {
        System.out.println("Bookstore Server is ready.");
    }

    public String purchaseBook(String title, String user) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 2001);
            InventoryInterface invStub = (InventoryInterface) registry.lookup("InventoryServer");
            PaymentInterface payStub = (PaymentInterface) registry.lookup("PaymentServer");

            if (invStub.checkAvailability(title)) {
                if (payStub.processPayment(user, 50.0,title)) {
                    return "Purchase successful: " + title;
                } else {
                    return "Purchase failed: payment declined.";
                }
            } else {
                return "Purchase failed: book unavailable.";
            }

        } catch (Exception e) {
            System.err.println("BookstoreServer error: " + e.toString());
            e.printStackTrace();
        }
        return "Purchase failed due to server error.";
    }

    public static void main(String args[]) {
        try {
            BookstoreServer server = new BookstoreServer();
            BookstoreInterface skelton = (BookstoreInterface) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry(2001);
            registry.bind("BookstoreServer", skelton);

        } catch (Exception e) {
            System.err.println("BookstoreServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}