package service;

import java.util.List;

import entity.Discount;
import entity.Item;

public class BillService {
    private Double totalPrice;
    private String calculationTotalPrice;

    private void calculateTotalPrice(List<Item> items){
        totalPrice = 0d;
        calculationTotalPrice = "";
        for(Item item : items){
            if(!calculationTotalPrice.isBlank())calculationTotalPrice += " + ";
            Double currentItemPrice = item.getTotalPrice();
            totalPrice = totalPrice + currentItemPrice;
            calculationTotalPrice += currentItemPrice;
        }
        calculationTotalPrice += (" = "+totalPrice);
    }
    
    public String getBill(List<Item> items, Discount discount){
        calculateTotalPrice(items);
        Double discountValue = discount.getDiscount(totalPrice);
        
        return
            (
                "Amount to be paid: "
                + (totalPrice-discountValue)
                + " Rs "
            )
            +
            "[Calcualation: "
            +calculationTotalPrice
            +(
                discountValue!=0d ?
                " - "
                +discountValue
                +" ("
                +discount.getStatement()
                +") ="
                +(totalPrice-discountValue)
                : ""
            )
            +" Rs]" 
        ;
        
    }
}
