package model;

import java.util.List;

public class Cataloge {
    private List<Beverage> rateCard;
    private static Cataloge cataloge;
    private Cataloge(List<Beverage> rateCard)
    {
        this.rateCard=rateCard;
    }
    public static Cataloge createCataloge(List<Beverage> rateCard)
    {
        cataloge=new Cataloge(rateCard);
        return cataloge;
    }
    public List<Beverage> getRateCard()
    {
        return rateCard;
    }
}
