package bankingSystem;

import java.rmi.Naming;
import java.util.Scanner;

public class BankClient {
    public static void main(String[] args) {
        try {
            Bank bank = (Bank) Naming.lookup("rmi://localhost/BankService");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                if (choice == 4) break;

                System.out.print("Enter Account Number: ");
                String accountNumber = scanner.next();

                switch (choice) {
                    case 1:
                        System.out.println("Balance: $" + bank.checkBalance(accountNumber));
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        System.out.println(bank.deposit(accountNumber, depositAmount));
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        System.out.println(bank.withdraw(accountNumber, withdrawAmount));
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}