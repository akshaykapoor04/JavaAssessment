package test;
import model.*;
import model.Beverage;
import model.Constant.TaxCatagory;
import org.junit.*;
import services.BillingService;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestForCafe {
    BillingService billingService;
    @Before
    public void intialise()
    {
       billingService=new BillingService(initRateCard(),initTaxCard());
    }
    public List<Beverage> initRateCard()
    {
        List<Beverage> rateCard=new ArrayList<>();
        rateCard.add(new HotCoffee("Latte",40));
        rateCard.add(new HotCoffee("Cappuccino",50));
        rateCard.add(new HotCoffee("Expresso",30));
        rateCard.add(new HotTea("Masala",15));
        rateCard.add(new HotTea("Black",10));
        rateCard.add(new ColdCoffee("Oreo",110));
        rateCard.add(new ColdCoffee("Frappe",125));
        rateCard.add(new ColdDrink("Pepsi",45));
        rateCard.add(new ColdDrink("Coca-Cola",45));
        rateCard.add(new ColdDrink("Mirinda",45));
        return rateCard;
    }
    public Map<TaxCatagory,Float> initTaxCard()
    {
        Map<TaxCatagory,Float> taxCard=new HashMap<>();
        taxCard.put(TaxCatagory.HOT_COFFEE, (float) 18.0);
        taxCard.put(TaxCatagory.COLD_COFFEE, (float) 18.0);
        taxCard.put(TaxCatagory.TEA, (float) 5);
        taxCard.put(TaxCatagory.COLD_DRINK, (float) 21);
        return taxCard;
    }
    @Test
    public void test1()
    {
        float output=billingService.getBillOf("1,3,3");
        assertEquals(118.0,output,0.1);
    }
    @Test
    public void test2()
    {
        float output=billingService.getBillOf("1,2,3");
        assertEquals(142.0,output,0.1);
    }
    @Test
    public void test3()
    {
        float output=billingService.getBillOf("");
        assertEquals(0.0,output,0.0);
    }

}
