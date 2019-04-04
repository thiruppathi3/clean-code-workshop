package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {
    double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : this) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

    int renterPoints() {
        int renterPoints = 0;
        for (Rental rental : this) {
            renterPoints += rental.renderPoints();
        }
        return renterPoints;
    }
}
