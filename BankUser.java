/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_management_system;

import java.util.*;
public class BankUser extends ATM{
    
    int trialPassword;
    boolean checkPassword;
    
    void getdetails(){
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("\nAccount number: "+accno);
        System.out.println("Holder's Name: "+name);
        System.out.println("Enter yout Four Digit Password: ");        
        try{
            trialPassword=sc.nextInt();
        }
        catch(Exception e){
            System.out.println("\nYou can only enter four digit Numeric value.");
        }
        
        checkdetails();
    }
    
    void checkdetails(){
        
        checkPassword=(Password==trialPassword);
        
        if(checkPassword==true){
            accessbankaccount();
        }
        else{
            System.out.println("The Password you entered is wrong. Please try again.");
        }
    }
    
    void accessbankaccount(){
        
        Scanner sc=new Scanner(System.in);
        
        int flag=1,c;
        float amount;
        
        while(flag>0){
            
            System.out.println("\nOption:");
            System.out.println("1.Check Balance");
            System.out.println("2.Withdraw ");
            System.out.println("3.Deposit");
            System.out.println("4.Account Summary");
            System.out.println("5.Exit");
            
            System.out.println("Enter your choice:");
            c=sc.nextInt();
            
            switch (c) {
                case 1:
                    checkbalance();
                    break;
                case 2:
                    System.out.println("\nEnter amount of money to be withdrawn: ");
                    amount=sc.nextInt();
                    
                    if(amount<0){
                        System.out.println("\nAmount can only be positive.");
                    }
                    else if(amount<=balance-500){
                        balance=withdraw(amount);
                        
                        System.out.println("\nYour updated account data is:- ");
                        accsummary();
                    }
                    else{
                        System.out.println("You cant withdraw this much amount.");
                    }   
                    break;
                case 3:
                    System.out.println("\nEnter amount of money to be deposited: ");
                    amount=sc.nextInt();
                    
                    if(amount<0){
                        System.out.println("\nAmount can only be positive.");
                    }
                    else{
                        balance=deposit(amount);
                        System.out.println("\nYour updated account data is:- ");
                        accsummary();
                    }
                    break;
                case 4:
                    accsummary();
                    break;
                case 5:
                    flag=-1;
                    break;
                default:
                    System.out.println("Enter a number between 1 and 5.");
                    break;
            }
        }
    }
    
}
