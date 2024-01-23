namespace NBOBankingAPI.Models;

public class PaymentDB {
    public int paymentId;
    public int paymentPlanId;
    public float amountPaid;
    public DateOnly paymentDate;
    public string? paymentMethod;
}