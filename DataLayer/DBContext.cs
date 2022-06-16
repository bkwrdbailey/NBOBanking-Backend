namespace DataLayer;

public class DBContext : DbContext
{
    public DBContext() : base() { }
    public DBContext(DbContextOptions options) : base(options) { }

    public DbSet<BankAccount> BankAccounts { get; set; }
    public DbSet<CreditAccount> CreditAccounts { get; set; }
    public DbSet<Transaction> Transactions { get; set; }
    public DbSet<User> Users { get; set; }
}



//1. dotnet ef migrations add initial -c GMDBContext --startup-project ../WebAPI
//2. dotnet ef database update --startup-project ../WebAPI
//if there's a new table or change in models, delete migrations folder and rerun first, then second