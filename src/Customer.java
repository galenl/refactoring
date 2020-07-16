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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentalsEnum = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (rentalsEnum.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentalsEnum.nextElement();
            thisAmount = amountFor(each);
//            switch (each.getMovie().getPriceCode()) {
//                case Movie.REGULAR :
//                    thisAmount += 2;
//                    if (each.getDaysRented() > 2)
//                        thisAmount += (each.getDaysRented() - 2) * 1.5;
//                    break;
//                case Movie.NEW_RELEASE :
//                    thisAmount += each.getDaysRented() * 3;
//                    break;
//                case Movie.CHILDRENS :
//                    thisAmount += 1.5;
//                    if (each.getDaysRented() > 3)
//                        thisAmount += (each.getDaysRented() - 3) * 1.5;
//                    break;
//                default:
//                    break;
//            }

            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    private double amountFor(Rental rental) {
        double result = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR :
                result += 2;
                if (rental.getDaysRented() > 2)
                    result += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE :
                result += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS :
                result += 1.5;
                if (rental.getDaysRented() > 3)
                    result += (rental.getDaysRented() - 3) * 1.5;
                break;
            default:
                break;
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
