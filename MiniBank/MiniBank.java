import java.util.Arrays;

/**
 * MiniBank — lab-07 state
 * Demonstrates: custom annotations (@Id, @Positive, @MaxLength) + AnnotationValidator.
 */
public class MiniBank {

    public static void main(String[] args) {
        // --- Annotation validation demo ---
        System.out.println("=== AnnotationValidator — valid account ===");
        Account good = new SavingsAccount("Riya", 10000, 2000);
        String[] errs = AnnotationValidator.validate(good);
        System.out.println(errs.length == 0 ? "No errors." : Arrays.toString(errs));

        System.out.println("\n=== AnnotationValidator — account with negative balance ===");
        Account bad = new CurrentAccount("BadActor", -100, 0);
        errs = AnnotationValidator.validate(bad);
        if (errs.length == 0) {
            System.out.println("No errors.");
        } else {
            for (String e : errs) System.out.println("  ERROR: " + e);
        }

        // --- Existing behaviour ---
        System.out.println("\n=== Account Interest Rates ===");
        Account[] accounts = {
            new SavingsAccount("Riya",  10000, 2000),
            new CurrentAccount("Aman",  5000,  3000),
            new FixedDepositAccount("Priya", 50000)
        };
        for (Account acc : accounts) {
            System.out.printf("%s — rate: %.1f%%  yearly: %.2f%n",
                    acc, acc.interestRate(), acc.yearlyInterest());
        }

        // WithdrawRule lambda
        System.out.println("\n=== WithdrawRule (lambda) ===");
        WithdrawRule rule = (acc, amt) -> acc.canWithdraw(amt);
        System.out.println("Allow withdraw 5000 from savings: " + rule.allow(accounts[0], 5000));
        System.out.println("Allow withdraw 9500 from savings: " + rule.allow(accounts[0], 9500));
    }
}
