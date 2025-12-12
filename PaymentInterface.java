import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PaymentInterface extends Remote {
    boolean processPayment(String user, double amount,String title) throws RemoteException;
}