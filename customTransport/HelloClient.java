package customTransport;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 7000);
            Hello obj = (Hello) registry.lookup("Hello");
            System.out.println(obj.sayHello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}