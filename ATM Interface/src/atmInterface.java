import java.util.Scanner;

public class atmInterface {
    public static void main(String[] args) {
        int balance = 10000, withdraw=0, deposit=0, transfer=0;
        String bname;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("Enter your pin: ");
        String pin = sc.next();
        System.out.println("Enter your bank name: ");
        bname = sc.next();

        System.out.println("\""+name+"\" -"+bname+" Welcomes You !!!");
        while (true) {
            System.out.println("\n\n-----------ATM----------");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.println("Choose the operation you want to perform: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nTransaction History....");
                    System.out.println("---------------------------------");
                    System.out.println("Amount Withdrawn Rs."+withdraw);
                    System.out.println("Amount Deposited Rs."+deposit);
                    System.out.println("Amount Transferred Rs."+transfer);
                    System.out.println("Balance Amount Rs."+balance);
                    break;

                case 2:
                    System.out.println("Enter money to withdraw: ");
                    withdraw = sc.nextInt();
                    if (balance >= withdraw) {
                        balance -= withdraw;
                        System.out.println("Collect your money Rs." + withdraw);
                        System.out.println("Your balance is Rs."+balance);
                    } else {
                        System.out.println("Sorry, Insufficient Balance !!!");
                    }
                    break;

                case 3:
                    System.out.println("Enter money to deposit: ");
                    deposit = sc.nextInt();

                    balance += deposit;
                    System.out.println("Rs." + deposit + " has been successfully deposited.");
                    System.out.println("Your balance is Rs."+balance);
                    break;

                case 4:
                    System.out.println("Enter money you want to transfer: ");
                    transfer = sc.nextInt();
                    System.out.println("Enter the account number to transfer amount to: ");
                    String acno = sc.next();

                    balance -= transfer;
                    System.out.println("Rs." + transfer + " has been successfully transferred to "+acno);
                    System.out.println("Your balance is Rs."+balance);
                    break;

                case 5:
                    System.exit(0);
                    System.out.println("QUIT !!!");

                default:
                    System.out.println("Invalid Choice !!!");
                    break;
            }
        }
    }
}
