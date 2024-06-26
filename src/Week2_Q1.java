class TaxUtilTest {
    public static void main(String[] args) {
        TaxUtil taxUtil = new TaxUtil();

//        double tax = taxUtil.calculateTax(100.0);
        double tax = taxUtil.calculateTax(100.0, 0.15);
        System.out.println("Calculated Tax: " + tax);
    }
}

//Question
/*
class TaxUtil {
    double rate = 0.15;

    public double calculateTax(double amount) {
        return amount * rate;
    }
}
*/

class TaxUtil {
    public double calculateTax(double amount, double rate) {
        return amount * rate;
    }
}
