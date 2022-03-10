package com.software.software.Discounts;

public class twoPassingersDiscount extends rideDiscounts{
    public twoPassingersDiscount(ridePrice r) {
        super(r);
    }
    @Override
    public int getPrice(){
        return (int) (super.getPrice()-(super.getPrice()/0.05));
    }
}