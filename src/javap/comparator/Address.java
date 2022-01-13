package javap.comparator;

import java.util.Comparator;
import java.util.stream.Stream;

public class Address {
    public final String street, postcode;
    public final int number;

    public Address(final String street, final int number, final String postcode) {
        this.street = street;
        this.number = number;
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return String.format("Address{street='%s', postcode='%s', number=%d}", street, postcode, number);
    }

    public static void main(String[] args) {
        Address[] addresses = {
                new Address("Hashemiye", 10, "123"),
                new Address("Mjidiye", 140, "333"),
                new Address("Salman", 15, "451"),
        };


        StreetComparatorReverse<Address> cmpStreet = new StreetComparatorReverse<>();
        Stream.of(addresses).sorted(cmpStreet).forEach(System.out::println);

        Comparator<Address> adRever = (a1,a2)-> Comparator.<String>reverseOrder().compare(a1.street, a2.street);
        Stream.of(addresses).sorted(adRever).forEach(System.out::println);
    }

    private static class StreetComparatorReverse<T extends Address> implements Comparator<T> {

        @Override
        public int compare(T o1, T o2) {
            if (o1 == null || o2 == null)
                throw new NullPointerException();

            return Comparator.<String>reverseOrder().compare(o1.street, o2.street);
        }
    }
}
