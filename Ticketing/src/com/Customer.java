package com;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Customer class
class Customer {
 private String name;
 private LocalDate dateOfBirth;
 private Ticket ticket;
 
 // Constructor
 public Customer(String name, LocalDate dateOfBirth) {
     this.name = name;
     this.dateOfBirth = dateOfBirth;
 }
 
 // Getters and setters
 public String getName() {
     return name;
 }
 
 public void setName(String name) {
     this.name = name;
 }
 
 public LocalDate getDateOfBirth() {
     return dateOfBirth;
 }
 
 public void setDateOfBirth(LocalDate dateOfBirth) {
     this.dateOfBirth = dateOfBirth;
 }
 
 public Ticket getTicket() {
     return ticket;
 }
 
 public void setTicket(Ticket ticket) {
     this.ticket = ticket;
 }
 
 // Override equals method
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true;
     if (obj == null || getClass() != obj.getClass()) return false;
     Customer customer = (Customer) obj;
     return Objects.equals(name, customer.name) && 
            Objects.equals(dateOfBirth, customer.dateOfBirth);
 }
 
 // Override hashCode method
 @Override
 public int hashCode() {
     return Objects.hash(name, dateOfBirth);
 }
 
 // Override toString method
 @Override
 public String toString() {
     return "Customer{name='" + name + "', dateOfBirth=" + dateOfBirth + "}";
 }
 
 // Method to book ticket
 public void bookTicket(String ticketClass, boolean isStandby, String mealCode) {
     this.ticket = new Ticket(ticketClass, isStandby, mealCode);
     System.out.println("Ticket booked successfully!");
     System.out.println("Your ticket number: " + ticket.getNumber());
     System.out.println("Your ticket code: " + ticket.getCode());
 }
 
 // Display methods
 public void displayClass() {
     if (ticket != null) {
         System.out.println("Ticket Class: " + ticket.getTicketClass());
     } else {
         System.out.println("No ticket booked yet.");
     }
 }
 
 public void displayNumber() {
     if (ticket != null) {
         System.out.println("Ticket Number: " + ticket.getNumber());
     } else {
         System.out.println("No ticket booked yet.");
     }
 }
 
 public void displayMealCode() {
     if (ticket != null) {
         System.out.println("Meal Code: " + ticket.getMealCode());
     } else {
         System.out.println("No ticket booked yet.");
     }
 }
 
 public void displayName() {
     System.out.println("Customer Name: " + name);
 }
}
