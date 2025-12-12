import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookstoreInterface extends Remote {
    String purchaseBook(String title, String user) throws RemoteException;
}