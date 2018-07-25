package model;

import model.Constant.TaxCatagory;

public interface Beverage {
    public float getPrice();
    public TaxCatagory getTaxCatagory();
    public String getDisplayName();
    public String getName();
}
