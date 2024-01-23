using NBOBankingAPI.Models;

namespace NBOBankingAPI.Database;

public interface IDatabaseCalls {
    // Adding new DB record methods
    Task<UserDB> AddUserRecord(UserDB newUser);
    Task<LoanDB> AddLoanRecord(LoanDB newLoan);
    Task<Boolean> AddAccountRecord(AccountDB newAccount);
    Task<PaymentDB> AddPaymentRecord(PaymentDB newPayment);
    Task<PaymentPlanDB> AddPaymentPlanRecord(PaymentPlanDB newPaymentPlan);
    Task<TransactionDB> AddTransactionRecord(TransactionDB newTransaction);

    // Updating current DB record methods
    Task<Boolean> UpdateAccountRecord(AccountDB updatedAccountData);

    // Getting DB record(s) methods
    Task<UserDB> GetUserRecord(string username);
    Task<List<PaymentDB>> GetAllLoanPaymentRecords();
    Task<PaymentPlanDB> GetPaymentPlanRecord();
    Task<List<AccountDB>> GetAllUserAccountRecords(int userId);
    Task<List<LoanDB>> GetAllUserLoanRecords();
    Task<List<TransactionDB>> GetAllAccountTransactionRecords(int bankAccountId);

    // Removing DB record(s) methods
    Task<Boolean> RemoveAccountRecord(int userId, string accountNum);
}