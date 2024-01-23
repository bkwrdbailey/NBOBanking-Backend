namespace NBOBankingAPI.Models;

public class Payment {
    public long amountPaid;
    public DateOnly datePaid;
    public string? paymentMethod;
}