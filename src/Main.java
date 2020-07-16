/**
 * @author galen
 */
public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie("头文字D", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("名侦探柯南", Movie.CHILDRENS);
        Movie movie3 = new Movie("变形金刚", Movie.REGULAR);

        Rental rental1 = new Rental(movie1, 4);
        Rental rental2 = new Rental(movie2, 2);
        Rental rental3 = new Rental(movie3, 3);

        Customer customer = new Customer("galen");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        System.out.println(customer.statement());
    }
}
