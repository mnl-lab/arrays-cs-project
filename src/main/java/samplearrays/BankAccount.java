package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;

    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions = new double[1000];
    int index = 0;
    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;

    }

    public void deposit(double amount){
        if (amount <=0 ){
            System.out.println("Can't deposit a negative value");
            return;
        }
        transactions[index] = amount;
        index += 1;
        currentBalance += amount;
        System.out.println("name: "+ name + ", balance: "+ currentBalance );



    }

    public void withdraw(double amount){
        if (amount <=0 || amount > currentBalance){
            System.out.println("unvalid amount to withdraw");
            return;
        }
        transactions[index] = -amount;
        index += 1;
        currentBalance -= amount;
        System.out.println("name: "+ name + ", balance: "+ currentBalance );



    }

    public void displayTransactions(){
        for (int i = 0; i < index; i++) {
            System.out.println("transaction number: "+ index + " | amount: " + transactions[i]);
        }


    }

    public void displayBalance(){
        System.out.println("current balance: " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
