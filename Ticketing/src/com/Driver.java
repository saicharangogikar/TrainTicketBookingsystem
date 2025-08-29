package com;

import java.time.LocalDate;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;
        
        System.out.println("=== Ticket Management System ===");
        
        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Create Customer Profile");
            System.out.println("2. Book Ticket");
            System.out.println("3. Display Ticket Information");
            System.out.println("4. Redeem Coupon");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    // Create customer profile
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
                    String dobString = scanner.nextLine();
                    LocalDate dob = LocalDate.parse(dobString);
                    
                    customer = new Customer(name, dob);
                    System.out.println("Customer profile created successfully!");
                    break;
                    
                case 2:
                    // Book ticket
                    if (customer == null) {
                        System.out.println("Please create a customer profile first.");
                        break;
                    }
                    
                    System.out.print("Enter ticket class (Economy/Business/First): ");
                    String ticketClass = scanner.nextLine();
                    
                    System.out.print("Is this a standby ticket? (true/false): ");
                    boolean isStandby = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline
                    
                    System.out.print("Enter meal code: ");
                    String mealCode = scanner.nextLine();
                    
                    customer.bookTicket(ticketClass, isStandby, mealCode);
                    break;
                    
                case 3:
                    // Display ticket information
                    if (customer == null) {
                        System.out.println("Please create a customer profile first.");
                        break;
                    }
                    
                    System.out.println("\n--- Ticket Information ---");
                    customer.displayName();
                    customer.displayClass();
                    customer.displayNumber();
                    customer.displayMealCode();
                    break;
                    
                case 4:
                    // Redeem coupon
                    if (customer == null || customer.getTicket() == null) {
                        System.out.println("Please book a ticket first.");
                        break;
                    }
                    
                    System.out.print("Enter coupon class (Economy/Business/First): ");
                    String couponClass = scanner.nextLine();
                    
                    System.out.print("Is this a standby coupon? (true/false): ");
                    boolean isCouponStandby = scanner.nextBoolean();
                    scanner.nextLine(); // Consume newline
                    
                    System.out.print("Enter meal code for coupon: ");
                    String couponMealCode = scanner.nextLine();
                    
                    Coupon coupon = new Coupon(LocalDate.now(), couponClass, isCouponStandby, couponMealCode);
                    customer.getTicket().setCoupon(coupon);
                    
                    System.out.println("Coupon redeemed successfully on " + LocalDate.now());
                    break;
                    
                case 5:
                    // Exit
                    System.out.println("Thank you for using the Ticket Management System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

