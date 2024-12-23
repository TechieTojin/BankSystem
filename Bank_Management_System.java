package bank_management_system;

import java.util.Scanner;
public class Bank_Management_System {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankUser[] acc = new BankUser[1000];
        int idno = 1, flag = 1;

        System.out.println("\t\t\t\t\tBank Management System");

        while (flag > 0) {
            System.out.println("\nOption:");
            System.out.println("1.Open a new Account");
            System.out.println("2.Access Bank Account");
            System.out.println("3.Transfer money to another Account");
            System.out.println("4.Exit");

            System.out.println("\nEnter your choice:");
            int c = sc.nextInt();

            switch (c) {
                case 1:
                    acc[idno - 1] = new BankUser(); // Instantiate BankUser object
                    acc[idno - 1].accno = idno;
                    acc[idno - 1].openaccount(); // Call openaccount() on the BankUser instance
                    if (acc[idno - 1].isvalid) {
                        idno++; // Increment idno if account is valid
                    }
                    break;

                case 2:
                    System.out.println("Enter the account number of the bank you want to access: ");
                    int accnum = sc.nextInt();

                    if (accnum >= idno || accnum <= 0) {
                        System.out.println("This account doesn't exist.");
                        continue;
                    }
                    if (acc[accnum - 1].isvalid) {
                        acc[accnum - 1].getdetails(); // Call getdetails on BankUser instance
                    } else {
                        System.out.println("Enter a valid account number.");
                    }
                    break;

                case 3:
                    // Similar logic as case 2, use acc[accnum-1] to access BankUser instance
                    break;

                case 4:
                    flag = -1;
                    break;

                default:
                    System.out.println("Enter a number between 1 and 4.");
                    break;
            }
        }
    }
}
