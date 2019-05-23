package Model;

public class ExpenseItem {
    private String name;
    private double amount;

    public ExpenseItem()
    {
        name = "none";
        amount = 0.00;
    }

    public ExpenseItem(String name, double amount)
    {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public boolean setAmount(double amount) {
        if(amount < 0.00){
            return false;
        }
        else {
            this.amount = amount;
            return true;
        }
    }
}
