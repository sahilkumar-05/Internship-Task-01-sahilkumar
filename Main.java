import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        // Adding sample accounts
        Account account1 = new Account("111A", "Sahil", 25000);
        Account account2 = new Account("112A", "Akash", 30000);
        Account account3 = new Account("121A", "Abrar", 2000);
        Account account4 = new Account("1123A", "Ali", 35000);

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);

        while (true) {
            System.out.println("\n\n\t\t\t\t\t\t WELCOME TO BANKING SYSTEM MANAGEMENT\n");
            System.out.println("Press 1 for display all Accounts");
            System.out.println("Press 2 for search any Account");
            System.out.println("Press 3 for withdraw amount");
            System.out.println("Press 4 for deposit amount");
            System.out.println("Enter 5 for check balance");
            System.out.println("Enter 6 for exit");
            System.out.println("Enter your choice ");

            //checking if inpout is any special character rather than number//
            if (!input.hasNextInt()) {
                input.next();
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                continue;
            }

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    bank.viewAccount();
                    break;
                case 2:
                    System.out.println("Enter account Number to Search:");
                    String find = input.nextLine();
                    Account account = bank.findAccount(find);
                    if (account != null) {
                        System.out.println("Account Found. " + "\nName: " + account.getAccHolder() + "\nAccount Number: " + account.getAccountNo() + "\nBalance: " + account.getBalance());
                    }
                    break;
                case 3:
                    System.out.println("Enter account Number to Withdraw From:");
                    String withdrawAccountNo = input.nextLine();
                    Account withdrawAccount = bank.findAccount(withdrawAccountNo);
                    if (withdrawAccount != null) {
                        System.out.println("Enter amount to withdraw:");
                        double withdraw = input.nextDouble();
                        input.nextLine(); // clear newline
                        withdrawAccount.withdrawAmount(withdraw);
                    }
                    break;
                case 4:
                    System.out.println("Enter account Number to Deposit To:");
                    String depositAccountNo = input.nextLine();
                    //creating an object //
                    Account depositAccount = bank.findAccount(depositAccountNo);
                    if (depositAccount != null) {

                        System.out.println("Enter the amount to deposit:");
                        double deposit = input.nextDouble();
                        input.nextLine(); // clear newline
                        depositAccount.depositAmount(deposit);
                    }
                    break;
                case 5:
                    System.out.println("Enter account Number to Check Balance:");
                    String balanceAccountNo = input.nextLine();
                    Account balanceAccount = bank.findAccount(balanceAccountNo);
                    if (balanceAccount != null) {
                        balanceAccount.checkBalance();
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice! Please enter a number between 1 and 6.");
            }
        }

    }
}