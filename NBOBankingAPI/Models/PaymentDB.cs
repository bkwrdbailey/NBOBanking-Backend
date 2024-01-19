namespace NBOBankingAPI.Models;

public class PaymentDB {
    int? paymentId;
    int? paymentPlanId;
    float? amountPaid;
    DateOnly paymentDate;
    string? paymentMethod;
}