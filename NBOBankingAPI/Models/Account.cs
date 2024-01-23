using System.Transactions;

namespace NBOBankingAPI.Models;

public class Account {
    public string? accountType;
    public string? accountNum;
    public float balance;
    public List<Transaction>? transactionHistory;
}