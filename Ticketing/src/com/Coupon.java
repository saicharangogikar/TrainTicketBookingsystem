package com;

import java.time.LocalDate;
import java.util.Objects;

//Coupon class
class Coupon {
private LocalDate dateOfRedemption;
private String couponClass;
private boolean isStandby;
private String mealCode;

// Constructor
public Coupon(LocalDate dateOfRedemption, String couponClass, boolean isStandby, String mealCode) {
    this.dateOfRedemption = dateOfRedemption;
    this.couponClass = couponClass;
    this.isStandby = isStandby;
    this.mealCode = mealCode;
}

// Getters and setters
public LocalDate getDateOfRedemption() {
    return dateOfRedemption;
}

public void setDateOfRedemption(LocalDate dateOfRedemption) {
    this.dateOfRedemption = dateOfRedemption;
}

public String getCouponClass() {
    return couponClass;
}

public void setCouponClass(String couponClass) {
    this.couponClass = couponClass;
}

public boolean isStandby() {
    return isStandby;
}

public void setStandby(boolean standby) {
    isStandby = standby;
}

public String getMealCode() {
    return mealCode;
}

public void setMealCode(String mealCode) {
    this.mealCode = mealCode;
}

// Override equals method
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Coupon coupon = (Coupon) obj;
    return Objects.equals(dateOfRedemption, coupon.dateOfRedemption) && 
           Objects.equals(couponClass, coupon.couponClass);
}

// Override hashCode method
@Override
public int hashCode() {
    return Objects.hash(dateOfRedemption, couponClass);
}

// Override toString method
@Override
public String toString() {
    return "Coupon{dateOfRedemption=" + dateOfRedemption + ", class='" + couponClass + 
           "', standby=" + isStandby + ", mealCode='" + mealCode + "'}";
}

// Compare method
public int compare(Coupon other) {
    int dateComparison = this.dateOfRedemption.compareTo(other.dateOfRedemption);
    if (dateComparison != 0) return dateComparison;
    return this.couponClass.compareTo(other.couponClass);
}

// CompareTo method (if we were to implement Comparable)
public int compareTo(Coupon other) {
    return this.mealCode.compareTo(other.mealCode);
}
}
	
	






