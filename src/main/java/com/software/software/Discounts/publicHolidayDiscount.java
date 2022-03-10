package com.software.software.Discounts;

public class publicHolidayDiscount extends rideDiscounts{
    public publicHolidayDiscount(ridePrice r) {
        super(r);
    }
    @Override
    public int getPrice(){
        return (int) (super.getPrice()-(super.getPrice()/0.05));
    }
}
