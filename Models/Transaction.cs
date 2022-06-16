namespace Models;

public class Transaction {
    public int id { get; set; }
    public int bankAcctId { get; set; }
    public double amount { get; set; }
    public DateTime date { get; set; }
    public string type { get; set; }
    public string description { get; set; }
}