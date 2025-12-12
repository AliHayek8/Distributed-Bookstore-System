import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

public class InventoryServer implements InventoryInterface {

    private String fileName;

    public InventoryServer(String fileName) {
        this.fileName = fileName;
        System.out.println("Inventory Server is ready.");
    }

    public boolean checkAvailability(String title) {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase(title)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading inventory file: " + e.getMessage());
        }
        return false;
    }

    public static void main(String args[]) {
        try {
            InventoryServer server = new InventoryServer("inventory.txt");
            InventoryInterface skelton = (InventoryInterface) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry(2001);
            registry.bind("InventoryServer", skelton);

        } catch (Exception e) {
            System.err.println("InventoryServer exception: " + e.toString());
            e.printStackTrace();
        }
    }
}