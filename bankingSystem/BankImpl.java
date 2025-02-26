package bankingSystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BankImpl extends UnicastRemoteObject implements Bank {
    private final Map<String, Double> accounts;

    public BankImpl() throws RemoteException {
        super();
        accounts = new HashMap<>();
        accounts.put("12345", 1000.0);
        accounts.put("67890", 500.0);
    }

    @Override
    public double checkBalance(String accountNumber) throws RemoteException {
        return accounts.getOrDefault(accountNumber, 0.0);
    }

    @Override
    public String deposit(String accountNumber, double amount) throws RemoteException {
        accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
        return "Deposited $" + amount + " into account " + accountNumber;
    }

    @Override
    public String withdraw(String accountNumber, double amount) throws RemoteException {
        if (!accounts.containsKey(accountNumber)) {
            return "Account not found.";
        }
        double balance = accounts.get(accountNumber);
        if (balance < amount) {
            return "Insufficient balance.";
        }
        accounts.put(accountNumber, balance - amount);
        return "Withdrew $" + amount + " from account " + accountNumber;
    }
}