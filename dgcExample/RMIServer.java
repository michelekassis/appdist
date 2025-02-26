package dgcExample;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            RemoteObjectImpl obj = new RemoteObjectImpl();
            Registry registry = LocateRegistry.createRegistry(7000);
            registry.rebind("RemoteObject", obj);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}