package com.software.software.Discounts;

public class firstRideDiscount extends rideDiscounts{
    public firstRideDiscount(ridePrice r) {
        super(r);
    }
    @Override
    public int getPrice(){
        return super.getPrice()-(super.getPrice()/10);
    }
}
