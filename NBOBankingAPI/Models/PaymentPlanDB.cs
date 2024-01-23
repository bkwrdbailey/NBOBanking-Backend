namespace NBOBankingAPI.Models;

public class PaymentPlanDB {
    public int paymentId;
    public int loanId;
    public Boolean onAutoPay;
    public float? amountDue;
    public DateOnly paymentDueDate;
}