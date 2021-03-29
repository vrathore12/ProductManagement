/*
 * Copyright (C) 2021 virendra
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package labs.pm.data;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.util.Objects;
import static labs.pm.data.Rating.*;

/**
 *
 * @author virendra
 */
public abstract class Product implements Rateable<Product> {

    /**
     * @param args the command line arguments
     */
    public static BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {
        this(id, name, price, NOT_RATED);
    }

//    public Product() {
//        this(0, "no name", BigDecimal.ZERO);
//
//    }
    

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + " Discount : " + getDiscount() + ", rating=" + rating.getStars() + '}';
    }

    /**
     * @param args the command line arguments
     */
    public int getId() {
        return id;
    }
    
    public LocalDate getBestBefore(){
        return LocalDate.now();
    }

//    public void setId(int id) {
//        this.id = id;
//    }
    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
    public BigDecimal getPrice() {
        return price;
    }

//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
    public BigDecimal getDiscount() {

        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    @Override
    public Rating getRating() {
        return rating;
    }

//    public abstract Product setRating(Rating rating);
//   {
//    return new Product(this.id,   this.name,   this.price, rating);
//   }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
//        if (obj != null && getClass() == obj.getClass()) {
        if (obj instanceof Product) {
            final Product other = (Product) obj;
            return this.id == other.id; //&& Objects.equals(this.name, other.name );
        }
        return false;
    }

}
