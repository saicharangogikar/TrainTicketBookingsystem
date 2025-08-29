package com;

import java.util.Objects;
import java.util.Random;

class Ticket {
    private String number;
    private String code;
    private String ticketClass;
    private boolean isStandby;
    private String mealCode;
    private Coupon coupon;
    
    // Constructor
    public Ticket(String ticketClass, boolean isStandby, String mealCode) {
        this.number = generateRandomNumber();
        this.code = generateRandomCode();
        this.ticketClass = ticketClass;
        this.isStandby = isStandby;
        this.mealCode = mealCode;
    }
    
    // Generate random ticket number
    private String generateRandomNumber() {
        Random rand = new Random();
        return "TKT" + (100000 + rand.nextInt(900000));
    }
    
    // Generate random ticket code
    private String generateRandomCode() {
        Random rand = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            code.append((char) (65 + rand.nextInt(26))); // A-Z
        }
        return code.toString();
    }
    
    // Getters and setters
    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getTicketClass() {
        return ticketClass;
    }
    
    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
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
    
    public Coupon getCoupon() {
        return coupon;
    }
    
    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
    
    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ticket ticket = (Ticket) obj;
        return Objects.equals(number, ticket.number) && 
               Objects.equals(code, ticket.code);
    }
    
    // Override hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(number, code);
    }
    
    // Override toString method
    @Override
    public String toString() {
        return "Ticket{number='" + number + "', code='" + code + "', class='" + ticketClass + 
               "', standby=" + isStandby + ", mealCode='" + mealCode + "'}";
    }
    
    // Compare method
    public int compare(Ticket other) {
        return this.number.compareTo(other.number);
    }
    
    // CompareTo method (if we were to implement Comparable)
    public int compareTo(Ticket other) {
        return this.code.compareTo(other.code);
    }
}
