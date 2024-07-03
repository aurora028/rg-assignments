class PayPalAccount {
    private String accountId;
    private double balance;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }
}

class AccountDetails {
    public static void main(String[] args) {
        PayPalAccount account = new PayPalAccount();
        account.setAccountId("PAYPAL12345");
        account.setBalance(1000.0);

        System.out.println("Account ID: " + account.getAccountId());
        System.out.println("Account Balance: $" + account.getBalance());

        account.setBalance(-500.0);
        System.out.println("Attempted to set negative balance.\nCurrent Balance: $" + account.getBalance());
    }
}

