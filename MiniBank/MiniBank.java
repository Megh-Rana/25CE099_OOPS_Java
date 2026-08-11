public class MiniBank {

    record BankInfo(String name, String branch) {
        @Override
        public String toString() {
            return "==============================\n"
                 + "  Bank  : " + name + "\n"
                 + "  Branch: " + branch + "\n"
                 + "==============================";
        }
    }

    enum MenuOption {
        OPEN_ACCOUNT,
        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        EXIT
    }

    public static void main(String[] args) {
        BankInfo bank = new BankInfo("MiniBank", "Main Branch");
        System.out.println(bank);

        Account[] accounts = {
            new Account("Riya", 5000),
            new Account("Aman", 3000),
            new Account("Priya")
        };

        accounts[0].deposit(2000);
        System.out.println(accounts[0].getOwnerName() + " balance after deposit 2000: " + accounts[0].getBalance());

        boolean result = accounts[0].withdraw(3000);
        System.out.println("Withdraw 3000: " + result + " | Balance: " + accounts[0].getBalance());

        result = accounts[0].withdraw(10000);
        System.out.println("Withdraw 10000: " + result + " | Balance: " + accounts[0].getBalance());

        System.out.println();
        for (Account acc : accounts) {
            System.out.println(acc.getAccountNumber() + " | " + acc.getOwnerName() + " | " + acc.getBalance());
        }
    }
}
