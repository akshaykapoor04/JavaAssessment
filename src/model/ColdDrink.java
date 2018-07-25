package model;

import model.Constant.TaxCatagory;

public class ColdDrink extends ColdBeverage {
    String name;
    float price;
    TaxCatagory taxCatagory;
    public ColdDrink(String name,float price)
    {
        this.name=name;
        this.price=price;
        taxCatagory=TaxCatagory.COLD_DRINK;
    }
    @Override
    public String getDisplayName() {
        return super.getDisplayName()+"ColdDrink."+this.getName();
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
