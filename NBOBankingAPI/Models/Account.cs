using System.Transactions;

namespace NBOBankingAPI.Models;

public class Account {
    string? accountType;
    string? accountNum;
    string? balance;
    Transaction[]? transactionHistory;
}