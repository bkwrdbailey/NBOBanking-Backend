namespace DataLayer;
public interface IDBRepo
{
    /// <summary>
    /// This will add a user record to the database
    /// </summary>
    /// <param name="user">A user object taken from the frontend</param>
    /// <returns>The newly created user record</returns>
    Task<User> CreateUser(User newUser);
    /// <summary>
    /// This will add a new bankAccount record for a specific user into the database
    /// </summary>
    /// <param name="newBankAcc">A new bankaccount object received from the frontend</param>
    /// <returns>The newly created bankaccount record</returns>
    Task<BankAccount> CreateBankAcc(BankAccount newBankAcc);
    /// <summary>
    /// This will add a new transaction record for a specific user into the database
    /// </summary>
    /// <param name="newTransaction">A newly created transaction object from the frontend</param>
    Task CreateTransaction(Transaction newTransaction);
    /// <summary>
    /// This will get all user transactions for a specified bank account or credit account
    /// </summary>
    /// <param name="userId">The id of the user</param>
    /// <param name="accountId">The id of the specific bank account or credit account</param>
    /// <returns>A list of transaction records</returns>
    Task<List<Transaction>> GetAllTransactions(int accountId);
    /// <summary>
    /// This will add a credit account record for a specific user into the database
    /// </summary>
    /// <param name="newCreditAcc"></param>
    /// <returns></returns>
    Task<CreditAccount> CreateCreditAcc(CreditAccount newCreditAcc);
}
