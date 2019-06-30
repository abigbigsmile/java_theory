package design_pattern.observer_designpattern;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        library.addBook(new Book(1, "smile"));
        library.addBook(new Book(2, "Hello"));
    }

}
