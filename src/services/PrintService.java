package services;

import model.BeverageOrdered;
import model.Beverage;

import java.util.List;

public class PrintService {
    String line="--------------------------------------------";
    public void printCataloge(List<Beverage> rateCard)
    {
        System.out.println("Menu:");
        for (int i=0;i<rateCard.size();i++)
        {
            Beverage beverage=rateCard.get(i);
            System.out.println((i+1)+beverage.getDisplayName()+" : "+beverage.getPrice());
        }
    }
    public void printOrderedItems(List<BeverageOrdered> itemList)
    {
        System.out.println("\nOrderDetails:");
        System.out.println(line);
        System.out.format("%3s\t%-10s\t%-10s\t%-10s\n", "No.", "Item", "Quantity", "Price");
        for(int i=0;i<itemList.size();i++)
        {
            BeverageOrdered beverageOrdered=itemList.get(i);
            System.out.format("%-3d\t%-10s\t%-10s\t%-10f\n", i + 1, beverageOrdered.getBeverage().getName(),beverageOrdered.getQuantity(),beverageOrdered.getBeverage().getPrice());
        }
    }
    public void printPrice(float total,float totalTax,float net)
    {
        System.out.println(line);
        System.out.println("\t\t\t\tTotal\t\t" + total);
        System.out.println("\t\t\t\tTax  \t\t" + totalTax + "\n");
        System.out.println(line);
        System.out.println("\t\t\t\tNet  \t\t" + net);
    }
}
