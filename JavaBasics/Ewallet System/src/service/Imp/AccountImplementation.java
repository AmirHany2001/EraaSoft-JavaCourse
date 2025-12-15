package service.Imp;

import model.Account;
import model.History;
import service.AccountService;
import model.EWallet;


import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountImplementation implements AccountService {
    Scanner scanner = new Scanner(System.in);
    Account account =  null;
    EWallet eWallet = EWallet.getInstance();
    AccountValidationImplementation accountValidationImplementation = new AccountValidationImplementation();



    @Override
    public void login(ApplicationImplementation app) {

        String accountName;

        accountName = loginName(app);
        account = loginPassword(accountName , app);

        if (account != null) {
            app.startApplicationFeatures(account);
        }
    }

    @Override
    public void signUp(ApplicationImplementation app) {
        String name , password ;
        String phoneNumber;
        int age ;
        System.out.println("Welcome to the sign-up service");

        name = signUpName(app);

        password = signUpPassword(app);

        phoneNumber = signUpPhoneNumber(app);

        age = signUpAge(app);

        account = new Account.Builder().setName(name).setAge(age)
                .setPassword(password).setPhoneNumber(phoneNumber).build();

        eWallet.addAccount(account);

        System.out.println("Your Account has been added successfully");
        app.startApplicationFeatures(account);

    }

    @Override
    public void deposit(Account account) {
        int amount , trial = 3;

        while (trial > 0){
            try{
                System.out.println("Please enter your amount ");
                amount = scanner.nextInt();
                scanner.nextLine();
                if (amount > 0) {
                    account.addBalance(amount);
                    System.out.println("Your account new balance after the deposit is " + account.getBalance());
                    account.addHistory(new History.Builder().setAmount(amount)
                            .setOperation("deposit").setName(account.getName()).build());
                    break;
                }
                else{
                    System.out.println("Not Valid Amount");
                    trial--;
                }
            }catch (InputMismatchException e){
                System.out.println("Not Valid Amount");
                trial--;
                scanner.nextLine();
            }
        }
        if(trial == 0){
            System.out.println("Invalid operation");
        }
    }

    @Override
    public void withdraw(Account account) {
        int amount = 0 , trial = 3;

        while(trial > 0){
            try{
                System.out.println("Please enter your amount ");
                amount = scanner.nextInt();
                scanner.nextLine();
                if ( amount > 0 && account.getBalance() >= amount) {
                    account.getMoney(amount);
                    System.out.println("Your account new balance after the withdraw is " + account.getBalance());
                    account.addHistory(new History.Builder().setAmount(amount)
                            .setOperation("withdraw").setName(account.getName()).build());
                    break;
                }
                else{
                    System.out.println("Not Valid Amount or Not Enough Balance");
                    trial--;
                }
            }catch (InputMismatchException e){
                System.out.println("Not Valid Amount");
                trial--;
                scanner.nextLine();
            }
        }
        if(trial == 0){
            System.out.println("Invalid operation");
        }
    }

    @Override
    public void transfer(Account senderAccount) {
         int money = 0 , flag;
         money = transferWithdraw(senderAccount,money);

         if(money > 0){
             flag = transferDeposit(money , senderAccount);
             if(flag > 0){
                 senderAccount.addHistory(new History.Builder().setAmount(money)
                         .setOperation("Sent money").setName(senderAccount.getName()).build());
             }
         }
    }

    @Override
    public int transferWithdraw(Account senderAccount , int money) {
        int amount  , trial = 3;
        while(trial > 0){
            try{
                System.out.println("Please enter your amount ");
                amount = scanner.nextInt();
                scanner.nextLine();
                if ( amount > 0 && senderAccount.getBalance() >= amount) {
                    senderAccount.getMoney(amount);
                    money = amount;
                    System.out.println("Your account new balance after the transferWithdraw is " + senderAccount.getBalance());
                    break;
                }
                else{
                    System.out.println("Not Valid Amount or Not Enough Balance");
                    trial--;
                }
            }catch (InputMismatchException e){
                System.out.println("Not Valid Amount");
                trial--;
                scanner.nextLine();
            }
        }
        if (trial == 0){
            System.out.println("Invalid operation");
            return 0;
        }
        return money;

    }

    @Override
    public int transferDeposit(int money ,  Account senderAccount) {
        String name ;
        int trial = 3;

        while(trial > 0){
            try{
                System.out.println("Please enter the account name that you want to send money to ");
                name = scanner.nextLine();

                if(accountValidationImplementation.isUsernameExist(name,eWallet) && !senderAccount.getName().equals(name)){
                    account = eWallet.getAccountByUsername(name);
                    account.addBalance(money);
                    System.out.println("Your account new balance after the transferDeposit is " + account.getBalance());
                    account.addHistory(new History.Builder().setAmount(money)
                            .setOperation("Received money").setName(account.getName()).build());
                    break;
                }
                System.out.println(" Username does not exist .... you can't send money to yourself ");
                trial--;
            }catch (InputMismatchException e){
                System.out.println("Not Valid Amount");
                trial--;
                scanner.nextLine();
            }
        }
        if(trial == 0){
            System.out.println("Invalid operation");
            senderAccount.addBalance(money);
            System.out.println("The sender balance returns to " +  senderAccount.getBalance());
        }
        return trial;
    }

    @Override
    public void deleteAccount(Account account) {
        eWallet.deleteAccount(account);
        System.out.println("Your account has been deleted successfully");
    }

    @Override
    public void showAccountDetails(Account account) {
        String approve ;

        System.out.println("Do you need to show your Password ?" +"\n" + "yes or no ");
        approve = scanner.nextLine();
        if (approve.equalsIgnoreCase("yes")){
            showDataWithPassword(account);
        }
        else{
            showDataWithOutPassword(account);
        }
    }

    @Override
    public void showDataWithPassword(Account account){
        String password;
        int trial = 3;
        while (trial > 0){
            System.out.println("Enter your Password");
            password = scanner.nextLine();
            if(account.getPassword().equals(password)){
                System.out.println(
                        "Your account name is " + account.getName() +"\n"
                                + "Your age is " + account.getAge() +"\n"
                                + "Your account phone number is " + account.getPhoneNumber() +"\n"
                                + "Your Balance is " + account.getBalance() + "\n"
                                + "Your Password is " + account.getPassword());
                break;
            }
            System.out.println("Password Does Not Match");
            trial--;
        }
        if(trial == 0){
            showDataWithOutPassword(account);
        }

    }

    @Override
    public void showDataWithOutPassword(Account account){
        System.out.println("Your account name is " + account.getName() +"\n"
                + "Your age is " + account.getAge() +"\n"
                + "Your account phone number is " + account.getPhoneNumber() +"\n"
                + "Your Balance is " + account.getBalance());
    }

    @Override
    public void logout(ApplicationImplementation app) {
        System.out.println("See you Later :)");
        app.startApplication();
    }

    @Override
    public  void changePassword(Account account) {
        int trial = 3;
        String oldPassword , newPassword ;

        while (trial > 0){
            System.out.println("Please enter your old password");
            oldPassword = scanner.nextLine();
            if(account.getPassword().equals(oldPassword)){
                System.out.println("please enter your new password");
                newPassword = scanner.nextLine();
                if(oldPassword.equals(newPassword)){
                    System.out.println("This Password has been used recently");
                    trial--;
                    continue;
                }
                else if (!accountValidationImplementation.checkPassword(newPassword)) {
                    System.out.println("Invalid password!");
                    trial--;
                    continue;
                }
                account.setPassword(newPassword);
            }
            else{
                System.out.println("Passwords do not match!");
                trial--;
                continue;
            }
            break;
        }

        if(trial == 0){
            System.out.println("Passwords didn't change");
        }else{
            System.out.println("Your Password has been changed successfully");
        }

    }

    @Override
    public String signUpName(ApplicationImplementation app){
        int trial = 3;
        String name = null;
        while (trial > 0) {
            System.out.println("Please enter your name:");
            name = scanner.nextLine();

            if (!accountValidationImplementation.checkUsername(name, eWallet)) {
                System.out.println("Invalid name");
                trial--;
                continue;
            }
            break;
        }
        checkTrials(trial , app);
        return name ;
    }

    @Override
    public String signUpPassword(ApplicationImplementation app){
        int trial = 3;
        String password = null;

        while (trial > 0) {
            System.out.println("Please enter your password:");
            password = scanner.nextLine();

            if (!accountValidationImplementation.checkPassword(password)) {
                System.out.println("Invalid password!");
                trial--;
                continue;
            }
            break;
        }
        checkTrials(trial , app);
        return password;
    }

    @Override
    public String signUpPhoneNumber(ApplicationImplementation app){
        int trial = 3;
        String phoneNumber = null;

        while (trial > 0) {

            System.out.println("Please enter your phone:");
            phoneNumber = scanner.nextLine().trim();
            phoneNumber = "+2" + phoneNumber ;

            if (!accountValidationImplementation.checkPhoneNumber(phoneNumber, eWallet)) {
                System.out.println("Invalid phone number!");
                trial--;
                continue;
            }
            break;
        }
        checkTrials(trial , app);
        return phoneNumber;
    }

    @Override
    public int  signUpAge(ApplicationImplementation app){
        int trial = 3;
        int age = 0;
        while (trial > 0) {
            try{
                System.out.println("Please enter your age:");
                age = scanner.nextInt();
                scanner.nextLine();

                if (!accountValidationImplementation.checkAge(age)) {
                    System.out.println("Invalid age! Must be ≥ 18.");
                    trial--;
                    continue;
                }
                break;
            }catch (InputMismatchException e){
                System.out.println("Invalid age!");
                trial--;
                scanner.nextLine();
            }
        }
        checkTrials(trial , app);
        return age;
    }

    @Override
    public void checkTrials(int trial , ApplicationImplementation app){
        if (trial == 0){
            System.out.println("You have tried 3 times .. try again later");
            app.startApplication();
        }
    }

    @Override
    public String loginName(ApplicationImplementation app){
        int trial = 3;
        String accountName = null;
        while(trial > 0) {
            System.out.println("Enter your account name: ");
            accountName = scanner.nextLine();
            if (!accountValidationImplementation.isUsernameExist(accountName, eWallet)) {
                System.out.println(" Username does not exist!");
                trial--;
                continue;
            }
            break;
        }
        checkTrials(trial , app);
        return  accountName;
    }

    @Override
    public Account loginPassword(String accountName , ApplicationImplementation app){
        int trial = 3;
        String accountPassword ;
        account = eWallet.getAccountByUsername(accountName);

        while(trial > 0) {
            System.out.println("Enter your account password: ");
            accountPassword = scanner.nextLine();

            if (!account.getPassword().equals(accountPassword)) {
                System.out.println(" Incorrect password!");
                trial--;
                continue;
            }
            break;
        }
        checkTrials(trial , app);
        return account;
    }

    @Override
    public void anotherService(ApplicationImplementation app , Account  account){
        System.out.println("Do you want to another service?" + "\n" + "yes or no ");
        String ans = scanner.nextLine();
        if( ans.equalsIgnoreCase("yes") ){
            app.startApplicationFeatures(account);
        }
        logout(app);
    }

    @Override
    public void showOperationHistory(Account account){
        System.out.println(account.getHistory());
    }



}
