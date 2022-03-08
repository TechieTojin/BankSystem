
package bank_management_system;

import java.util.*;
public class Bank_Management_System {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        BankUser[] acc=new BankUser[1000];
        int idno=1,flag=1;
        
        System.out.println("\t\t\t\t\tBank Management System");
        
        while(flag>0){
            System.out.println("\nOption:");
            System.out.println("1.Open a new Account");
            System.out.println("2.Access Bank Account");
            System.out.println("3.Transfer money to another Account");
            System.out.println("4.Exit");
            
            System.out.println("\nEnter your choice:");
            int c=sc.nextInt();
            
            switch (c) {
                case 1:
                    acc[idno-1]=new BankUser();
                    acc[idno-1].accno=idno;
                    acc[idno-1].openaccount();
                    if(acc[idno-1].isvalid==true)
                        idno++;
                    break;
                case 2:
                    System.out.println("Enter the account number of the bank you want to access: ");
                    int accnum=sc.nextInt();
                    
                    if(accnum>=idno || accnum<=0){
                        System.out.println("This account doesn't exist.");
                        continue;
                    }
                    if(acc[accnum-1].isvalid==true)
                        acc[accnum-1].getdetails();
                    else
                        System.out.println("Enter a valid account number.");
                    break;
                case 3:
                    System.out.println("Enter you bank account number: ");
                    accnum=sc.nextInt();
                    
                    if(accnum>=idno || accnum<=0){
                        System.out.println("This account doesn't exist.");
                        continue;
                    }
                        
                    int tp;
                    System.out.println("Holder's Name: "+acc[accnum-1].name);
                    System.out.println("Enter yout Four Digit Password: ");
                    tp=sc.nextInt();
                    
                    if(tp==acc[accnum-1].Password){
                        System.out.println("Enter the account number of the receiving account:");
                        int an=sc.nextInt();
                    
                        if(an>=idno || an<=0){
                            System.out.println("This account doesn't exist.");
                            continue;
                        }
                        
                        if(an==accnum){
                            System.out.println("You can not transfer money to yourself.");
                            continue;   
                        }
                        
                        System.out.println("\nEnter amount of money to be transfered: ");
                        int amount=sc.nextInt();
                        
                        if(amount<0){
                            System.out.println("\nAmount can only be positive.");
                        }
                        else if(amount<=acc[accnum-1].balance-500){
                            acc[accnum-1].balance=acc[accnum-1].balance-amount;
                            acc[an-1].balance=acc[an-1].balance+amount;
                            
                            System.out.println("\nYour updated account data is:- ");
                            acc[accnum-1].accsummary();
                        }
                        else{
                            System.out.println("You cant transfer this much amount.");
                        }   
                    }
                    else{
                        System.out.println("The Password you entered is wrong. Please try again.");
                    }
                    break;
                case 4:
                    flag=-1;
                    break;
                default:
                    System.out.println("Enter a number between 1 and 4.");
                    break;
            }
        }
        
    }
}
