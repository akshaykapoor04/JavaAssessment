package model;

import model.Constant.TaxCatagory;

public class HotTea extends HotBeverage {
    String name;
    float price;
    TaxCatagory taxCatagory;
    public HotTea(String name,float price)
    {
        this.name=name;
        this.price=price;
        taxCatagory=TaxCatagory.TEA;
    }
    @Override
    public String getDisplayName() {
        return super.getDisplayName()+"tea."+this.getName();
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public TaxCatagory getTaxCatagory() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}
