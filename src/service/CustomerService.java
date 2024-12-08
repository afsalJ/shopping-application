package service;
import java.util.*;
import entity.*;

public class CustomerService {
    private List<Item> items;
    private Discount discount;
    private BillService billService;
    private Scanner sc;

    public CustomerService(){
        sc = new Scanner(System.in);
        billService = new BillService();
        items = new ArrayList<>();
        start();
    }

    public void start(){
        System.out.print("Item: ");
        String[] itemsString = sc.nextLine().split(",");
        for(String item : itemsString){
            items.add(new Item(item.trim()));
        } 
        System.out.print("Discount: ");
        String discountString = sc.nextLine().trim();
        discount = new Discount(discountString);

        System.out.println(billService.getBill(items, discount));
    }
}
