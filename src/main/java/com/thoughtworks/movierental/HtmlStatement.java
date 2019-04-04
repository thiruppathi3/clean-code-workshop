package com.thoughtworks.movierental;

class HtmlStatement {

    public String display(Rentals rentals, String customerName) {
        String htmlStatement = "<h1>Rental Record for <b>" + customerName + "</b></h1><br>";
        for (Rental rental : rentals) {
            htmlStatement += rental.getMovie().getTitle() + " " +
                    String.valueOf(rental.amount()) + "<br>";
        }

        //add footer lines result
        htmlStatement += "Amount owed is <b>" + String.valueOf(rentals.totalAmount()) + "</b><br>";
        htmlStatement += "You earned <b>" + String.valueOf(rentals.renterPoints())
                + "</b> frequent renter points<br>";
        return htmlStatement;
    }
}
