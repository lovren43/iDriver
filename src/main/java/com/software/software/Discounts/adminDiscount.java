package com.software.software.Discounts;

public class adminDiscount extends rideDiscounts{
    public adminDiscount(ridePrice r) {
        super(r);
    }
    @Override
    public int getPrice(){
        return super.getPrice()-(super.getPrice()/10);
    }
}
