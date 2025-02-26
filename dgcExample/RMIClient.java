package dgcExample;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 7000);
            RemoteObject obj = (RemoteObject) registry.lookup("RemoteObject");
            obj.sayHello();

            System.out.println("Releasing reference to remote object...");
            obj = null;
            System.gc();

            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}