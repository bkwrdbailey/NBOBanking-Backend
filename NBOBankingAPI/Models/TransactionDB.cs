namespace NBOBankingAPI.Models;

public class TransactionDB {
    public int transactionId;
    public int accountId;
    public float transactionAmount;
    public string? description;
    public string? sending;
    public string? receiving;
}