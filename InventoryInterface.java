import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InventoryInterface extends Remote {
    boolean checkAvailability(String title) throws RemoteException;
}