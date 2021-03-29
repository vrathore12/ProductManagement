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

        // pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        pm.parseProduct("D,101,Tea,1.99,0,2021-09-19");
        pm.printProductReport(101);
//     pm.reviewProduct(101, Rating.FOUR_STAR, "Nice cup of tea!");
        pm.parseReview("101,4,It was fantastic");
//         pm.parseReview("101,1,Hot tea!");
        pm.parseReview("101,3,No comments!");
        pm.parseReview("101,5,This is amazing!");
        pm.parseReview("101,1,It did not taste like tea!");
//        pm.reviewProduct(101, Rating.ONE_STAR, "Hot tea!");
//        pm.reviewProduct(101, Rating.THREE_STAR, "No comments!");
//        pm.reviewProduct(101, Rating.FIVE_STAR, "This is amazing!");
//        pm.reviewProduct(101, Rating.ONE_STAR, "It did not taste like tea!");
        pm.printProductReport(101);

        pm.parseProduct("F,109,Sandwich,6.99,3,2021-09-29");
        pm.printProductReport(109);

//      pm.changeLocale("ru-RU");
        pm.createProduct(102, "Coffee", BigDecimal.valueOf(2.00), Rating.NOT_RATED);
//      pm.printProductReport(102);
        pm.reviewProduct(102, Rating.THREE_STAR, "Nice cup of Coffee!");
        pm.reviewProduct(102, Rating.FOUR_STAR, "really needed that ");
        pm.reviewProduct(102, Rating.TWO_STAR, "Coffee was okay!");
        //pm.printProductReport(102);

        pm.createProduct(103, "Cake", BigDecimal.valueOf(5.99), Rating.NOT_RATED, LocalDate.now().plusDays(2));
//      pm.printProductReport(103);
        pm.reviewProduct(103, Rating.FIVE_STAR, "I like cakes");
        pm.reviewProduct(103, Rating.THREE_STAR, "Did not get my choice of flavor");
        pm.reviewProduct(103, Rating.FOUR_STAR, "Cream was so buttery");
        pm.reviewProduct(103, Rating.FOUR_STAR, "They are really nice!");
//      pm.printProductReport(p3);

        pm.createProduct(104, "Chocolate", BigDecimal.valueOf(3.99), Rating.NOT_RATED, LocalDate.now().plusDays(30));
//      pm.printProductReport(p4);
        pm.reviewProduct(104, Rating.FIVE_STAR, "I love chocolates");
        pm.reviewProduct(104, Rating.ONE_STAR, "Too sweet");
        pm.reviewProduct(104, Rating.THREE_STAR, "They should make more chocolates");
//      pm.printProductReport(p4);

        pm.createProduct(105, "Hot Chocolate", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//      pm.printProductReport(p5);
        pm.reviewProduct(105, Rating.FOUR_STAR, "Nice!");
        pm.reviewProduct(105, Rating.FIVE_STAR, "Big fan of cocoa");
        pm.reviewProduct(105, Rating.FOUR_STAR, "Best in the rains!");
        pm.reviewProduct(105, Rating.FIVE_STAR, "I can have this anytime and anywhere");
//      pm.printProductReport(p5);

        pm.createProduct(106, "Cookie", BigDecimal.valueOf(0.99), Rating.NOT_RATED, LocalDate.now().plusDays(1));
//      pm.printProductReport(p6);
        pm.reviewProduct(106, Rating.FOUR_STAR, "I got it free!");
        pm.reviewProduct(106, Rating.ONE_STAR, "More flavors needed");
        pm.reviewProduct(106, Rating.THREE_STAR, "Peanut butter with nuts is my favorite!");
        pm.reviewProduct(106, Rating.FIVE_STAR, "");
        pm.reviewProduct(106, Rating.FIVE_STAR, "samples!");
        pm.printProductReport(106);

//Duplicate Addition
        pm.createProduct(107, "Brownie", BigDecimal.valueOf(2.99), Rating.NOT_RATED);
//      pm.printProductReport(p7);
        pm.reviewProduct(107, Rating.ONE_STAR, "Too chewy");
        pm.reviewProduct(107, Rating.FIVE_STAR, "Big fan!");
//      pm.printProductReport(p7);

        pm.printProducts(p -> p.getPrice().floatValue() > 2, (p1, p2) -> p1.getRating().ordinal() - p2.getRating().ordinal());
//      pm.printProducts((p1,p2) -> p2.getPrice().compareTo(p1.getPrice());

        pm.getDiscounts().forEach((rating, discount) -> System.out.println(rating + "\t" + discount));

        Comparator<Product> ratingSorter = ((p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
        Comparator<Product> priceSorter = ((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()));

//        pm.printProducts(ratingSorter.thenComparing(priceSorter);
//        pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());
//        Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(2.99), Rating.FOUR_STAR);
//        Product p3 = pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p4 = pm.createProduct(104, "Cookie", BigDecimal.valueOf(1.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p5 = p3.setRating(Rating.THREE_STAR);
//        //p3 = p3.setRating(Rating.FOUR_STAR);
//        Product p6 = pm.createProduct(103, "Chocolate", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//        Product p7 = pm.createProduct(103, "Chocolate", BigDecimal.valueOf(3.99), Rating.FIVE_STAR);
//        
//        System.out.println("Equals : "+p6.equals(p7));
//        p1.setId(101);
//        p1.setName("Tea");
//        p1.setPrice(BigDecimal.valueOf(1.99));
//        System.out.println(p1.getId()+" "+p1.getName()+" "+p1.getPrice()+" "+p1.getDiscount()+" "+p1.getRating().getStar());
//        System.out.println(p2.getId()+" "+p2.getName()+" "+p2.getPrice()+" "+p2.getDiscount()+" "+p2.getRating().getStar());
//        System.out.println(p3.getId()+" "+p3.getName()+" "+p3.getPrice()+" "+p3.getDiscount()+" "+p3.getRating().getStar());
//        System.out.println(p4.getId()+" "+p4.getName()+" "+p4.getPrice()+" "+p4.getDiscount()+" "+p4.getRating().getStar());
//        System.out.println(p5.getId()+" "+p5.getName()+" "+p5.getPrice()+" "+p5.getDiscount()+" "+p5.getRating().getStar());
//        System.out.println(p3.getId()+" "+p3.getName()+" "+p3.getPrice()+" "+p3.getDiscount()+" "+p3.getRating().getStar());
//        
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);
//        System.out.println(p5);
//        System.out.println(p6);
//        System.out.println(p7);
//        
//        if(p3 instanceof Food){
//            LocalDate date = ((Food)p3).getGetBestBeforeDate();
//            
//        }
    }
}
