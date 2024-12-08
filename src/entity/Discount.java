package entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Discount {
    private Double percentage;
    private Double levelPrice;
    private String statement;
    private Pattern pattern = Pattern.compile("(\\d+)%\\s*\\w+\\s*\\w+\\s*\\w+\\s*(\\d+)\\s*Rs");

    public Discount(String discount){
        Matcher matcher =pattern.matcher(discount);
        if(matcher.find()){
            this.percentage = Double.parseDouble(matcher.group(1));
            this.levelPrice = Double.parseDouble(matcher.group(2));
            this.statement = percentage+"% discount";
        }else{
            if(!discount.equalsIgnoreCase(  "None")){
                System.out.println("Invalid discount for Discount()");
            }else{
                percentage=0d;
                levelPrice = 0d;
                statement = "";
            }
        }
    }

    public Double getDiscount(Double totalPrice){
        if(percentage != 0d){
            if(totalPrice>levelPrice){
                return totalPrice*(percentage/100.0);
            }
        }
        return 0d;
    }

    public String getStatement(){
        return statement;
    }
}
