package services;

import model.BeverageOrdered;
import model.Beverage;
import model.Cataloge;
import model.Constant.TaxCatagory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BillingService {
    private Cataloge cataloge;
    private TaxService taxService;
    private PrintService printService;
    public BillingService(List<Beverage> rateCard, Map<TaxCatagory,Float> taxCard)
    {
        cataloge=Cataloge.createCataloge(rateCard);
        taxService=TaxService.getTaxService(taxCard);
        printService=new PrintService();
        printService.printCataloge(cataloge.getRateCard());
    }
    public float getBillOf(String input)
    {

        InputService inputService=new InputService();
        List<Integer> items;
        float net=0;
        try {
            items = inputService.getItems(input);
            List<BeverageOrdered> itemList=getBerverageOrdered(items);
            printService.printOrderedItems(itemList);
            net=getTotalPrice(itemList);

        }catch (NullPointerException e)
        {
            System.out.println("\n\nWrong input");
        }

        return net;
    }
    public List<BeverageOrdered> getBerverageOrdered(List<Integer> items)
    {
        Collections.sort(items);
        int lastitem=-1;
        List<BeverageOrdered> itemList=new ArrayList<>();

        for(int i=0;i<items.size();i++)
        {
            if(lastitem!=items.get(i))
            {
                itemList.add(new BeverageOrdered(cataloge.getRateCard().get(items.get(i)),1));
                lastitem=items.get(i);
            }
            else
            {
                BeverageOrdered beverageOrdered=itemList.get(i-1);
                beverageOrdered.setQuantity();
                itemList.remove(i-1);
                itemList.add(beverageOrdered);

            }
        }
        return itemList;
    }
    public float getTotalPrice(List<BeverageOrdered> itemList)
    {
        float total=0;
        float totalTax=0;
        float net=0;
        for(int i=0;i<itemList.size();i++)
        {
            Beverage beverage=itemList.get(i).getBeverage();
            float taxAmount=(taxService.getTaxCard().get(beverage.getTaxCatagory())/100)*beverage.getPrice();
            totalTax=totalTax+taxAmount*itemList.get(i).getQuantity();
            total=total+(beverage.getPrice()*itemList.get(i).getQuantity());
        }
        totalTax=Math.round(totalTax);
        net=totalTax+total;
        printService.printPrice(total,totalTax,net);
        return net;
    }
}
