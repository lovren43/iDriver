package com.software.software.Discounts;

public abstract class rideDiscounts implements ridePrice{
    private ridePrice ride;

    public rideDiscounts(ridePrice r){
        ride=r;
    }
    @Override
    public int getRidePrice() {
        return this.getRidePrice();
    }

    public int getPrice() {
        return 0;
    }
}
