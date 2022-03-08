/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_management_system;


public class ATM extends Accounts{
    
    void checkbalance(){
        System.out.println("\nTotal Balance of Account Number "+accno+" is: "+balance);
    }
    
    float withdraw(float amount){
        
        balance=balance-amount;
        return balance;
    }
    
    float deposit(float amount){
        
        balance=balance+amount;
        return balance;
    }
    
    void accsummary(){
        System.out.println("\nAccount number: "+accno);
        System.out.println("Holder's Name: "+name);
        System.out.println("Holder's Balance: "+balance);
    }
    
}
