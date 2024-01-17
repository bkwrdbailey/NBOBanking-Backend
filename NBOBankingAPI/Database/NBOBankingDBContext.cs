using Microsoft.EntityFrameworkCore;
using NBOBankingAPI.Models;

namespace NBOBankingAPI.Database;

public class NBOBankingDBContext : DbContext {
    public NBOBankingDBContext() : base() {}
    public NBOBankingDBContext(DbContextOptions options) : base(options) {}
    DbSet<UserDB> Users { get; set; }
    DbSet<BankAccountDB> BankAccounts { get; set; }
    DbSet<LoanDB> Loans { get; set; }
}