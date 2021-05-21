/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs.pm.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import labs.pm.data.Product;
import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

/**
 *
 * @author virendra
 */
public class Shop {

    public static void main(String args[]) {
        ProductManager pm = new ProductManager("en-GB");
        pm.printProductReport(101);
        pm.createProduct(164, "Kombucha", BigDecimal.valueOf(2.99), Rating.NOT_RATED);
        pm.reviewProduct(164, Rating.TWO_STAR, "Looks like tea but is it?");
        pm.reviewProduct(164, Rating.FOUR_STAR, "Fine Tea");
        pm.reviewProduct(164, Rating.FOUR_STAR, "This is not tea");
        pm.reviewProduct(164, Rating.FIVE_STAR, "Perfect!");
        pm.printProductReport(164);
        pm.printProducts(p -> p.getPrice().floatValue()<2,
                (p1,p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
        pm.getDiscounts().forEach(
        (rating, discount) -> System.out.println(rating+ "\t"+ discount));
        

        
    }
}
