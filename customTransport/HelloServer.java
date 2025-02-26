package customTransport;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMISocketFactory;

public class HelloServer {
    public static void main(String[] args) {
        try {
            RMISocketFactory.setSocketFactory(new CustomTransport());
            HelloImpl obj = new HelloImpl();
            Registry registry = LocateRegistry.createRegistry(7000);
            registry.rebind("Hello", obj);
            System.out.println("Custom Transport Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}