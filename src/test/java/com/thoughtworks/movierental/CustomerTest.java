package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    final private String customerName = "Mr. X";
    final private String movieName1 = "Movie A";
    final private String movieName2 = "Movie B";
    final private String movieName3 = "Movie C";

    @Test
    public void test() {
    }

    @Test
    public void customerTest() {
        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName1, Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie(movieName2, Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie(movieName3, Movie.CHILDRENS), 1));

        Assert.assertEquals("Rental Record for " + customerName + "\n"
                + "\t" + movieName1 + "\t"
                + String.valueOf(2.0) + "\n"
                + "\t" + movieName2 + "\t"
                + String.valueOf(3.0) + "\n"
                + "\t" + movieName3 + "\t"
                + String.valueOf(1.5) + "\n"
                + "Amount owed is " + String.valueOf(6.5) + "\n"
                + "You earned " + String.valueOf(3)
                + " frequent renter points", customer.statement());
    }

    @Test
    public void customerTestMoreDays() {
        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName1, Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie(movieName2, Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie(movieName3, Movie.CHILDRENS), 4));

        Assert.assertEquals("Rental Record for Mr. X\n" +
                "\tMovie A\t3.5\n" +
                "\tMovie B\t6.0\n" +
                "\tMovie C\t3.0\n" +
                "Amount owed is 12.5\n" +
                "You earned 4 frequent renter points", customer.statement());
    }


    @Test
    public void customerTestNewReleaseMoreDays() {
        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName1, Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie(movieName2, Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie(movieName3, Movie.CHILDRENS), 1));

        Assert.assertEquals("Rental Record for Mr. X\n" +
                "\tMovie A\t2.0\n" +
                "\tMovie B\t6.0\n" +
                "\tMovie C\t1.5\n" +
                "Amount owed is 9.5\n" +
                "You earned 4 frequent renter points", customer.statement());
    }

    @Test
    public void customerTestChildrenMoreDays() {
        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName1, Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie(movieName2, Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie(movieName3, Movie.CHILDRENS), 4));

        Assert.assertEquals("Rental Record for Mr. X\n" +
                "\tMovie A\t2.0\n" +
                "\tMovie B\t3.0\n" +
                "\tMovie C\t3.0\n" +
                "Amount owed is 8.0\n" +
                "You earned 3 frequent renter points", customer.statement());
    }

    @Test
    public void customerTestHtmlStatement() {
        Customer customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie(movieName1, Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie(movieName2, Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie(movieName3, Movie.CHILDRENS), 4));

        Assert.assertEquals("<h1>Rental Record for <b>Mr. X</b></h1><br>" +
                "Movie A 2.0<br>" +
                "Movie B 3.0<br>" +
                "Movie C 3.0<br>" +
                "Amount owed is <b>8.0</b><br>" +
                "You earned <b>3</b> frequent renter points<br>", customer.htmlStatement());
    }


    @Test
    public void singleLoopVsMultiple() {
        for (int j = 0; j < 100; j++) {

            //single loop
            int x = 0, y = 0, z = 0;
            long l = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                x++;
                y++;
                z++;
            }
            l = System.currentTimeMillis() - l;


            //multiple loops doing the same thing
            int a = 0, b = 0, c = 0;
            long m = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                a++;
            }
            for (int i = 0; i < 100000000; i++) {
                b++;
            }
            for (int i = 0; i < 100000000; i++) {
                c++;
            }
            m = System.currentTimeMillis() - m;
            System.out.println(String.format("%d,%d", l, m));

        }
    }

}