package services;

import model.Constant.TaxCatagory;

import java.util.Map;

public class TaxService {
    private Map<TaxCatagory,Float> taxCard;
    private static TaxService taxService;
    private TaxService(Map<TaxCatagory,Float> taxCard)
    {
        this.taxCard=taxCard;
    }
    public static TaxService getTaxService(Map<TaxCatagory,Float> taxCard)
    {
        taxService=new TaxService(taxCard);
        return taxService;
    }
    public Map<TaxCatagory,Float> getTaxCard()
    {
        return taxCard;
    }
}
