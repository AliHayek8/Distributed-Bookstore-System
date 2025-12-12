import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

public class PaymentServer implements PaymentInterface {

    public PaymentServer() {
        System.out.println("Payment Server is ready.");
    }

    public boolean processPayment(String user, double amount,String title) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("payments.txt", true))) {
            writer.write(user + " paid: " + amount +" for this book : "+ title + "\n");
            return true;
        } catch (IOException e) {
            System.err.println("Payment processing error: " + e.getMessage());
        }
        return false;
    }

    public static void main(String args[]) {
        try {
            PaymentServer server = new PaymentServer();
            PaymentInterface skelton = (PaymentInterface) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry(2001);
            registry.bind("PaymentServer", skelton);

        } catch (Exception e) {
            System.err.println("PaymentServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}