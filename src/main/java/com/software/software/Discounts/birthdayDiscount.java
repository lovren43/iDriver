package com.software.software.Discounts;

public class birthdayDiscount extends rideDiscounts{
    public birthdayDiscount(ridePrice r) {
        super(r);
    }
    @Override
    public int getPrice(){
        return super.getPrice()-(super.getPrice()/10);
    }
}

