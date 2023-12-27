package Exception;
import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException, ServerBusyException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient funds. Cannot withdraw.");
        }

        // Simulate server being busy
        if (Math.random() < 0.2) {
            throw new ServerBusyException("Server is busy. Please try again later.");
        }

        balance -= amount;
        System.out.println("Withdrawal successful. Current balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class ServerBusyException extends Exception {
    public ServerBusyException(String message) {
        super(message);
    }
}

class UserDefinedException extends Exception {
    public UserDefinedException(String message) {
        super(message);
    }
}

public class BankingApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(initialBalance);

        try {
            System.out.print("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);

            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();
            account.withdraw(withdrawalAmount);

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (ServerBusyException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());

        } finally {
            System.out.println("Final balance: " + account.getBalance());
        }

        scanner.close();

	}

}
