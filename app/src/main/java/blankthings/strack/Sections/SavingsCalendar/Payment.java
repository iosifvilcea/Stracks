package blankthings.strack.Sections.SavingsCalendar;

/**
 * Created by iosifvilcea on 12/10/16.
 */


public class Payment {

    private double paymentAmount;
    private String paymentName;

    public Payment(double paymentAmount, String paymentName) {
        this.paymentAmount = paymentAmount;
        this.paymentName = paymentName;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}
