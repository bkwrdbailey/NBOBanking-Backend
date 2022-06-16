namespace Models;

public class CreditAccount {
    public int id { get; set; }
    public int userId { get; set; }
    public double availableAmt { get; set; }
    public double owedAmt { get; set; }
}