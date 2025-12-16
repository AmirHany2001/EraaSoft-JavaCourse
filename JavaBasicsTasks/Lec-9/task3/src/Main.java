

void main() {

    BankAccount bankAccount = new BankAccount();
    Depositor depositor = new Depositor(bankAccount);
    Withdrawer withdrawer = new Withdrawer(bankAccount);
    depositor.start();
    withdrawer.start();


}
