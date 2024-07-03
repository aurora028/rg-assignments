class PayPalService {
    private static PayPalService instance;

    private PayPalService() {
        // Extra Code
    }

    public static PayPalService getInstance() {
        if (instance == null) {
            synchronized (PayPalService.class) {
                if (instance == null) {
                    instance = new PayPalService();
                }
            }
        }
        return instance;
    }

    public void processPayment(double amount) {
        // Logic to process payment
        System.out.println("Processing payment of $" + amount);
    }
}

class Main {
    public static void main(String[] args) {
        PayPalService payPalService = PayPalService.getInstance();
        payPalService.processPayment(100.0);
    }
}

