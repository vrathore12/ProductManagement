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
//        Locale loc = Locale.US;
        ProductManager pm = new ProductManager("en-GB");

        pm.parseProduct("D,101,Tea,1.99,0,2021-09-19");
        pm.printProductReport(101);
        pm.parseReview("101,4,It was fantastic");
        pm.parseReview("101,1,Hot tea!");
        pm.parseReview("101,3,No comments!");
        pm.parseReview("101,5,This is amazing!");
        pm.parseReview("101,1,It did not taste like tea!");
        pm.printProductReport(101);

        pm.parseProduct("F,109,Sandwich,6.99,3,2021-09-29");
        pm.printProductReport(109);
        System.out.println();

        
        pm.createProduct(102, "Coffee", BigDecimal.valueOf(2.00), Rating.NOT_RATED);
        pm.printProductReport(102);
        pm.reviewProduct(102, Rating.THREE_STAR, "Nice cup of Coffee!");
        pm.reviewProduct(102, Rating.FOUR_STAR, "really needed that ");
        pm.reviewProduct(102, Rating.TWO_STAR, "Coffee was okay!");
        pm.printProductReport(102);

        pm.createProduct(103, "Cake", BigDecimal.valueOf(5.99), Rating.NOT_RATED, LocalDate.now().plusDays(2));
        pm.printProductReport(103);
        pm.reviewProduct(103, Rating.FIVE_STAR, "I like cakes");
        pm.reviewProduct(103, Rating.THREE_STAR, "Did not get my choice of flavor");
        pm.reviewProduct(103, Rating.FOUR_STAR, "Cream was so buttery");
        pm.reviewProduct(103, Rating.FOUR_STAR, "They are really nice!");
        pm.printProductReport(103);

        pm.createProduct(104, "Chocolate", BigDecimal.valueOf(3.99), Rating.NOT_RATED, LocalDate.now().plusDays(30));
        pm.printProductReport(104);
        pm.reviewProduct(104, Rating.FIVE_STAR, "I love chocolates");
        pm.reviewProduct(104, Rating.ONE_STAR, "Too sweet");
        pm.reviewProduct(104, Rating.THREE_STAR, "They should make more chocolates");
        pm.printProductReport(104);

        pm.createProduct(105, "Hot Chocolate", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.printProductReport(105);
        pm.reviewProduct(105, Rating.FOUR_STAR, "Nice!");
        pm.reviewProduct(105, Rating.FIVE_STAR, "Big fan of cocoa");
        pm.reviewProduct(105, Rating.FOUR_STAR, "Best in the rains!");
        pm.reviewProduct(105, Rating.FIVE_STAR, "I can have this anytime and anywhere");
        pm.printProductReport(105);

        pm.createProduct(106, "Cookie", BigDecimal.valueOf(0.99), Rating.NOT_RATED, LocalDate.now().plusDays(1));
        pm.printProductReport(106);
        pm.reviewProduct(106, Rating.FOUR_STAR, "I got it free!");
        pm.reviewProduct(106, Rating.ONE_STAR, "More flavors needed");
        pm.reviewProduct(106, Rating.THREE_STAR, "Peanut butter with nuts is my favorite!");
        pm.reviewProduct(106, Rating.FIVE_STAR, "");
        pm.reviewProduct(106, Rating.FIVE_STAR, "samples!");
        pm.printProductReport(106);

//Duplicate Addition
        pm.createProduct(107, "Brownie", BigDecimal.valueOf(2.99), Rating.NOT_RATED);
        pm.printProductReport(107);
        pm.reviewProduct(107, Rating.ONE_STAR, "Too chewy");
        pm.reviewProduct(107, Rating.FIVE_STAR, "Big fan!");
        pm.printProductReport(107);

        //
        System.out.println("----------------------");
        pm.printProducts(p -> p.getPrice().floatValue() > 2, (p1, p2) -> p1.getRating().ordinal() - p2.getRating().ordinal());
       
        System.out.println("----------------------");
        
        pm.getDiscounts().forEach((rating, discount) -> System.out.println(rating + "\t" + discount));
        System.out.println("----------------------");
        
        Comparator<Product> ratingSorter = ((p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
        System.out.println("----------------------");
        Comparator<Product> priceSorter = ((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()));
        System.out.println("----------------------");

    }
}
