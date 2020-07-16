package com.galen;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author galen
 */
public class Customer {

    private String name;

    private final Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public String statement() {
        Enumeration<Rental> rentalsEnum = rentals.elements();
        String result = "com.galen.Rental Record for " + getName() + "\n";

        while (rentalsEnum.hasMoreElements()) {
            Rental each = rentalsEnum.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentalsEnum = rentals.elements();
        while (rentalsEnum.hasMoreElements()) {
            Rental each = rentalsEnum.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentalsEnum = rentals.elements();
        while (rentalsEnum.hasMoreElements()) {
            Rental each = rentalsEnum.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
