package model;

import model.Constant.TaxCatagory;

public class ColdCoffee extends ColdBeverage {
    String name;
    float price;
    TaxCatagory taxCatagory;
    public ColdCoffee(String name,float price)
    {
        this.name=name;
        this.price=price;
        taxCatagory=TaxCatagory.COLD_COFFEE;
    }
    @Override
    public String getDisplayName() {
        return super.getDisplayName()+"Coffee."+this.getName();
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public TaxCatagory getTaxCatagory() {
        return taxCatagory;
    }

    @Override
    public String getName() {
        return name;
    }
}
