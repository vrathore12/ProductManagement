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
import java.time.LocalDate;

/**
 *
 * @author virendra
 */
public class Food extends Product{
    
    private LocalDate getBestBeforeDate;

    /**
     * Get the value of getBestBeforeDate
     *Get the value of the best before date of the Product
     * @return the value of getBestBeforeDate
     */
    public LocalDate getGetBestBeforeDate() {
        return getBestBeforeDate;
    }

    public Food(int id, String name, BigDecimal price, Rating rating, LocalDate getBestBeforeDate) {
        super(id, name, price, rating);
        this.getBestBeforeDate = getBestBeforeDate;
    }

    @Override
    public String toString() {
        return super.toString()+" "+ getBestBeforeDate;
    }

    @Override
    public BigDecimal getDiscount() {
        return (getBestBeforeDate.isEqual(LocalDate.now()) ? super.getDiscount() : BigDecimal.ZERO); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product setRating(Rating rating) {
     return new Food(getId(), getName(), getPrice(), rating, getBestBeforeDate);   
    }
    
    
    

}
