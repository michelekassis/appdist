package bankingSystem;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BankServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(6000);
            Bank bank = new BankImpl();
            Naming.rebind("BankService", bank);
            System.out.println("Banking System RMI Server is running...");
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}