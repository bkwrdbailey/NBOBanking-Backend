namespace Datalayer;

public class DBContext : DbContext
{
    public DBContext() : base() { }
    public DBContext(DbContextOptions options) : base(options) { }

    DbSet<BankAccount> BankAccounts { get; set; }
    DbSet<CreditAccount> CreditAccounts { get; set; }
    DbSet<Transaction> Transactions { get; set; }
    DbSet<User> Users { get; set; }
}

//1. dotnet ef migrations add initial -c GMDBContext --startup-project ../WebAPI
//2. dotnet ef database update --startup-project ../WebAPI
//if there's a new table or change in models, delete migrations folder and rerun first, then second