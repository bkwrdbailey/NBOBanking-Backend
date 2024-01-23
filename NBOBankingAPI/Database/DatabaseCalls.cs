using NBOBankingAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace NBOBankingAPI.Database;

public class DatabaseCalls : IDatabaseCalls {
    private readonly NBOBankingDBContext _context;
    public DatabaseCalls(NBOBankingDBContext context) {
        _context = context;
    }

    // Adding Records to Database
    public async Task<UserDB> AddUserRecord(UserDB newUser) {

    }

    public async Task<LoanDB> AddLoanRecord(LoanDB newLoan) {

    }

    public async Task<Boolean> AddAccountRecord(AccountDB newAccount) {

    }

    public async Task<PaymentDB> AddPaymentRecord(PaymentDB newPayment) {

    }

    public async Task<PaymentPlanDB> AddPaymentPlanRecord(PaymentPlanDB newPaymentPlan) {

    }

    public async Task<TransactionDB> AddTransactionRecord(TransactionDB newTransaction) {

    }

    // Updating Records in Database
    public async Task<Boolean> UpdateAccountRecord(AccountDB updatedAccountData) {

    }

    // Getting Records From the Database
    public async Task<UserDB> GetUserRecord(string username) {

    }

    public async Task<List<PaymentDB>> GetAllLoanPaymentRecords() {

    }

    public async Task<PaymentPlanDB> GetPaymentPlanRecord() {

    }

    public async Task<List<AccountDB>> GetAllUserAccountRecords(int userId) {

    }

    public async Task<List<LoanDB>> GetAllUserLoanRecords() {

    }

    public async Task<List<TransactionDB>> GetAllAccountTransactionRecords(int bankAccountId) {
        
    }

    // Removing Records from the Database
    public async Task<Boolean> RemoveAccountRecord(int userId, string accountNum) {

        return true;
    }
}