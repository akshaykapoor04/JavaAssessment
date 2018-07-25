package model;

public class BeverageOrdered {
    private Beverage beverage;
    private int quantity;
    public BeverageOrdered(Beverage beverage,int quantity)
    {
       this.beverage=beverage;
       this.quantity=quantity;
    }

    public void setQuantity() {
        this.quantity = this.quantity+1;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public int getQuantity() {
        return quantity;
    }

}
