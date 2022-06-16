using System.Linq;
namespace DataLayer;

public class DBCalls : IDBRepo
{
    private readonly DBContext _context;
    public DBCalls(DBContext context)
    {
        _context = context;
    }

    public async Task<User> CreateUser(User newUser)
    {
        _context.Users.Add(newUser);
        await _context.SaveChangesAsync();
        return newUser;
    }

    public async Task<BankAccount> CreateBankAcc(BankAccount newBankAcc)
    {
        _context.BankAccounts.Add(newBankAcc);
        await _context.SaveChangesAsync();
        return newBankAcc;
    }

    public async Task CreateTransaction(Transaction newTransaction)
    {
        _context.Transactions.Add(newTransaction);
        await _context.SaveChangesAsync();
    }

    public async Task<List<Transaction>> GetAllTransactions(int accountId)
    {
        return await _context.Transactions.FromSqlRaw($"Select * From Transactions Where bankAcctId = {accountId}").ToListAsync();
    }

    public async Task<CreditAccount> CreateCreditAcc(CreditAccount newCreditAcc)
    {
        _context.CreditAccounts.Add(newCreditAcc);
        await _context.SaveChangesAsync();
        return newCreditAcc;
    }
}
