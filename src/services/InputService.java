package services;

import java.util.ArrayList;
import java.util.List;

public class InputService {
    public List<Integer> getItems(String input)
    {
        List<Integer> items=new ArrayList<>();
        int i=0;
        String temp="";
        if(input.length()>0) {
            while (i <= input.length()) {
                if (i == input.length() || input.charAt(i) == ',') {
                    items.add(Integer.parseInt(temp) - 1);
                    temp = "";
                } else {
                    temp = temp + input.charAt(i);
                }

                i++;

            }
        }
        else throw new NullPointerException();
        return items;
    }
}
