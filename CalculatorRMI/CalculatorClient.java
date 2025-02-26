import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 5000);
            Calculator calc = (Calculator) registry.lookup("CalculatorService");

            System.out.println("Addition (5+3): " + calc.add(5, 3));
            System.out.println("Subtraction (10-4): " + calc.subtract(10, 4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}