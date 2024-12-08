package entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {
    private String name;
    private Double price;
    private Double quantity;
    private Pattern pattern = Pattern.compile("([a-zA-Z\\-\\s]+)\\s*\\((\\d+)\\s*@\\s*(\\d+)\\s*Rs\\)");

    public Item(String item){
        Matcher matcher = pattern.matcher(item);
        if(matcher.find()){
            this.name = matcher.group(1);
            this.price = Double.parseDouble(matcher.group(2));
            this.quantity = Double.parseDouble(matcher.group(3));
        }else{
            System.out.println("Invalid format of Item in Item()!");
        }
    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public Double getTotalPrice(){
        return quantity*price;
    }
}
