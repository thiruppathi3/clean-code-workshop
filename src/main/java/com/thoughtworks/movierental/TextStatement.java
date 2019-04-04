package com.thoughtworks.movierental;

class TextStatement {
    public String display(Rentals rentals, String name) {
        String statement = "Rental Record for " + name + "\n";
        for (Rental rental : rentals) {
            statement += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rental.amount()) + "\n";
        }

        //add footer lines result
        statement += "Amount owed is " + String.valueOf(rentals.totalAmount()) + "\n";
        statement += "You earned " + String.valueOf(rentals.renterPoints())
                + " frequent renter points";
        return statement;
    }
}
