namespace NBOBankingAPI.Models;

public class PaymentPlanDB {
    int? paymentId;
    int? loanId;
    Boolean onAutoPay;
    float? amountDue;
    DateOnly paymentDueDate;
}