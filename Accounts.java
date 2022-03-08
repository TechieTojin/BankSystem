/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_management_system;

import java.util.*;
public class Accounts implements Bank{
    
    int accno;
    int Password;
    String name;
    float balance;
    boolean isvalid=true;
    
    @Override
    public void openaccount(){
        Scanner sc = new Scanner(System.in);
        generatePassword();
        
        System.out.println("\nYour account number: "+accno);
        
        System.out.println("Enter your name: ");
        name=sc.nextLine();
        
        System.out.println("Enter amount money you want to deposit: ");
        balance=sc.nextFloat();
        
        if(balance<500){
            System.out.println("Your initial deposit can not be below 500.");
            isvalid=false;
            accno=0;
            name="NA";
        }
        
        if(isvalid==true){
            System.out.println("\nYour account has been created. Your account details are: ");
            accdetails();
        }
        else{
            System.out.println("\nYour account can not be created");
        }
    }
    
    @Override
    public void generatePassword(){
        int max=9999;
        int min=1000;
        
        Password=(int)(Math.random()*(max-min+1)+min);
    }
   
    void accdetails(){
        System.out.println("\nAccount number: "+accno);
        System.out.println("Holder's Name: "+name);
        System.out.println("Four Digit Account Password: "+Password);
        System.out.println("Holder's Balance: "+balance);
    }
}
