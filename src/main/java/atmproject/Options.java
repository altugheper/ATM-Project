package atmproject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Options extends Account {




    boolean flag = true;
    //Checking account process =>
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();


    public void login(){

        System.out.println("Welcome to TechProEd ATM");
        do {
            data.put(12345, 1234);
            data.put(23456, 2345);
            data.put(34567, 3456);
            data.put(45678, 4567);

            try{
                System.out.println("Please enter your account number:");
                setAccountNumber(input.nextInt());
                System.out.println("Pin numarasi giriniz:");
                setPinNumber(input.nextInt());
            }catch (Exception e){
                System.out.println("You have enter a wrong character. Please only submit numbers or type 'Q' to exit");
                input.nextLine();
                String exit = input.next();

                if (exit.equalsIgnoreCase("q")){
                    flag = false;
                }
            }

            int count = 0;
            for (Map.Entry<Integer, Integer> w:data.entrySet()){
                if (w.getKey().equals(getAccountNumber()) && w.getValue().equals(getPinNumber())){
                    getAccountTypes(); //Go to Account Types
                }else {
                    count++;
                }
            }

            if (count == data.size()){
                System.out.println("You have entered wrong account number or PIN number");
            }

        }while (flag);

    }


    public void checkingOperations(){
        do {
            displayMenu();

            int option = input.nextInt();

            if (option==4){
                break;
            }

            switch (option){
                case 1:
                    System.out.println("Remaining balance in your Checking Balance: "
                            + moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    getCheckingWithdraw();
                    break;
                case 3:
                    getCheckingDeposit();
                default:
                    System.out.println("Incorrect value. Please type 1, 2, 3, or 4");

            }

        }while (true);

        getAccountTypes();
    }


    public void savingOperations(){
        do {
            displayMenu();

            int option = input.nextInt();
            if (option == 4){
                break;
            }

            switch (option){
                case 1:
                    System.out.println("Remaining balance in your Checking Balance: "
                            + moneyFormat.format(getSavingBalance()));
                case 2:
                    getSavingWithdraw();
                    break;
                case 3:
                    getSavingDeposit();
                default:
                    System.out.println("Incorrect value. Please type 1, 2, 3, or 4");
            }

        }while (true);
        getAccountTypes();
    }

    //Displaying options menu
    public void displayMenu(){
        System.out.println("Please choose an option: ");
        System.out.println("1: Check Balance");
        System.out.println("2: Withdraw");
        System.out.println("3: Deposit");
        System.out.println("4: Exit");
    }

    public void getAccountTypes(){

        System.out.println("Please choose the account type you would like to make a transaction: ");
        System.out.println("1: Checking Account");
        System.out.println("2: Saving Account");
        System.out.println("3: Exit");

        int option = input.nextInt();

        switch (option){
            case 1:
                System.out.println("Your Checking Account: ");
                checkingOperations();
                break;
            case 2:
                System.out.println("Your Saving Account: ");
                savingOperations();
                break;
            case 3:
                System.out.println("Thank you for using ATM");
                flag = false; //The customer exceeds limit
                break;
            default:
                System.out.println("Incorrect value. Please type 1, 2, or 3");
        }




    }



}
