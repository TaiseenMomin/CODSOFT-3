import java.util.Scanner;

class UserAccount {
    private float balance;

    public UserAccount(float balance) {
        this.balance = balance;
    }

    public void withdraw(float amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal is Successful!");
            System.out.println("Your Available balance is " + balance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit is Successful! Your available balance is: " + balance);
        } else {
            System.out.println("Enter a Positive Amount!");
        }
    }

    public float getBalance() {
        return balance;
    }
}

class ATM {
    private UserAccount userAcc;

    public ATM(UserAccount userAcc) {
        this.userAcc = userAcc;
    }

    public void choice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose Option: ");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the withdrawal amount: ");
                    float withdrawAmt = sc.nextFloat();
                    userAcc.withdraw(withdrawAmt);
                    break;
                case 2:
                    System.out.println("Enter the deposit amount: ");
                    float depositAmt = sc.nextFloat();
                    userAcc.deposit(depositAmt);
                    break;
                case 3:
                    System.out.println("Your available balance is: " + userAcc.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();  // Close the scanner to avoid resource leaks
                    return;
                default:
                    System.out.println("Invalid Choice!!!");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        UserAccount ua = new UserAccount(5000);
        ATM atm = new ATM(ua);
        atm.choice();
    }
}
