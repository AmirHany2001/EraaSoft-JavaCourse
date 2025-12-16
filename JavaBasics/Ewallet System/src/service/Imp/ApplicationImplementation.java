package service.Imp;

import model.Account;
import service.ApplicationService;
import model.EWallet;

import java.util.InputMismatchException;
import java.util.Scanner;



public class ApplicationImplementation implements ApplicationService {

    AccountImplementation accountImplementation = new AccountImplementation();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void exit() {
        System.out.println("See you next time!");
        System.exit(0);
    }

    @Override
    public void startApplicationFeatures(Account account) {
        int choice ;

        System.out.println("Welcome to the Application features");

        while(true){
            try{
                System.out.println("please choose number from the following:");
                System.out.println("""
                    1. Deposit                   2. Withdrawal       3.TransferMoney\s
                    4. operationHistory          5. ChangePassword   6.ShowAccountDetails\s
                    7. DeleteAccount             8. Logout\s""");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1:
                        accountImplementation.deposit(account);
                        break;
                    case 2:
                        accountImplementation.withdraw(account);
                        break;
                    case 3:
                        accountImplementation.transfer(account);
                        break;
                    case 4:
                        accountImplementation.showOperationHistory(account);
                        break;
                    case 5:
                        accountImplementation.changePassword(account);
                        break;
                    case 6:
                        accountImplementation.showAccountDetails(account);
                        break;
                    case 7:
                        accountImplementation.deleteAccount(account);
                        startApplication();
                        break;
                    case 8:
                        accountImplementation.logout(this);
                        break;
                }
                accountImplementation.anotherService(this ,  account);
            }catch (InputMismatchException e) {
                System.out.println("Invalid input .. try again");
            }
        }
    }

    @Override
    public void startApplication() {
        EWallet eWallet = EWallet.getInstance();

        int choice ;

        while(true){
            try{
                System.out.println("Welcome to" + eWallet.getName());
                System.out.println("please choose number from the following:");
                System.out.println(" 1. login       2. signUp    3. exitProgram ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        accountImplementation.login(this);
                        break;
                    case 2:
                        accountImplementation.signUp(this);
                        break;
                    case 3:
                        exit();
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input .. try again");
            }
        }
    }
}
