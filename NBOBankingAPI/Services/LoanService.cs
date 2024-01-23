using NBOBankingAPI.Database;
using NBOBankingAPI.Models;

namespace NBOBankingAPI.Services;

public class LoanService : ILoanService {
    private readonly IDatabaseCalls _dbService;
    public LoanService(IDatabaseCalls dbService) {
        _dbService = dbService;
    }

    public async Task<Boolean> AddNewLoanToDB(Loan newLoan) {
        await ;
        return true;
    }

    public async Task<List<Loan>> GetLoansFromDB(int userId) {
        await ;
        return null;
    }

    public async Task<Boolean> UpdateLoanInfoInDB(Loan updatedLoanData) {
        await ;
        return true;
    }
}