using NBOBankingAPI.Models;

namespace NBOBankingAPI.Services;

public interface ILoanService {
    Task<Boolean> AddNewLoanToDB(Loan newLoan);
    Task<List<Loan>> GetLoansFromDB(int userId);
    Task<Boolean> UpdateLoanInfoInDB(Loan updatedLoanData);
}