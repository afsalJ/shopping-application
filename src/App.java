import java.util.List;

import entity.Discount;
import entity.Item;
import service.BillService;

public class App {
    public static void main(String[] args) throws Exception {
        BillService billService = new BillService();
        System.out.println(
        billService.getBill(List.of(new Item("Headphones (1 @ 3000 Rs)"),new Item("Mobile case (1 @ 500 Rs)")), new Discount("15% on orders above 3000 Rs"))
        );
    }
}
