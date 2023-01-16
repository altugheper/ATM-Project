package atmproject;

/*
        checking account
        saving account

        Withdraw
        Deposit

        double checkingBalance;
        double savingBalance;

        accountNumber;
        pinNumber;

        */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int accountNumber; //Account Number
    private int pinNumber; //PIN

    private double checkingBalance; //Checking Account Balance
    private double savingBalance; //Saving Account Balance

    //Adjusting decimal of amount of money
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    //Asking user for input
    Scanner input = new Scanner(System.in);

    //Generating Getter & Setter
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }


    //The amount of money left in Checking Balance after Withdrawing
    private double calculateCheckingBalanceAfterWithdraw(double amount){
        checkingBalance =- amount;
        return checkingBalance;
    }

    //The amount of money left in Checking Balance after Deposit
    private double calculateCheckingBalanceAfterDeposit(double amount){
        checkingBalance =+ amount;
        return checkingBalance;
    }

    //The amount of money left in Saving Balance after Withdrawing
    private double calculateSavingBalanceAfterWithdraw(double savingAmount){
        savingBalance =- savingAmount;
        return savingBalance;
    }

    //The amount of money left in Saving Balance after Deposit
    private double calculateSavingBalanceAfterDeposit(double savingAmount){
        savingBalance =+ savingAmount;
        return savingBalance;
    }

    //Interaction with customer for Withdrawing -- Checking Balance
    public void getCheckingWithdraw(){
        System.out.println("You have " + moneyFormat.format(checkingBalance) + " in your Checking Balance" );
        System.out.println("Please enter the amount of money you would like to withdraw: ");
        double amount = input.nextDouble();
        if (amount <= 0) {
            System.out.println("You have entered an incorrect value");
            getCheckingWithdraw(); //recursive method //methodu tekrardan cagirma
        }else if (amount <= checkingBalance){
            displayCurrentAmount(checkingBalance);
        }else {
            System.out.println("Insufficient Balance");
        }
    }

    //Interaction with customer for Deposit -- Checking Balance
    public void getCheckingDeposit(){
        System.out.println("You have " + moneyFormat.format(checkingBalance) + " in your Checking Balance" );
        System.out.println("Please enter the amount of money you would like to deposit: ");
        double amount = input.nextDouble();
        if (amount <= 0){
            System.out.println("You have entered an incorrect value");
            getCheckingDeposit(); //recursive method
        }else {
            displayCurrentAmount(checkingBalance);
        }
    }

    //Interaction with customer for Withdrawing -- Saving Balance
    public void getSavingWithdraw() {
        displayCurrentAmount(savingBalance);
        System.out.println("Please enter the amount of money you would like to withdraw: ");
        double amount = input.nextDouble();
        if (amount <= 0){
            System.out.println("You have entered an incorrect value");
            getSavingWithdraw();
        }else if (amount <= savingBalance){
            displayCurrentAmount(savingBalance);
        }else {
            System.out.println("Insufficient Balance");
        }
    }

    //Interaction with customer for Deposit -- Saving Balance
    public void getSavingDeposit(){
        displayCurrentAmount(savingBalance);
        System.out.println("Please enter the amount of money you would like to deposit: ");
        double amount = input.nextDouble();
        if (amount <= 0){
            System.out.println("You have entered an incorrect value");
            getSavingDeposit();
        }else {
            displayCurrentAmount(savingBalance);
        }
    }

    //Showing remaining balance
    public void displayCurrentAmount(double balance){
        System.out.println("You have " + moneyFormat.format(balance) + " in your Checking Balance" );
    }



}
