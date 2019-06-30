package design_pattern.observer_designpattern;

import java.util.ArrayList;
import java.util.List;

public class Library extends Observable {

    private List<Book> books = new ArrayList<>();

    public Library() {
        Observer readerA = new ReadreA();
        Observer readerB = new ReaderB();
        this.addObserver(readerA);
        this.addObserver(readerB);
    }

    public void addBook(Book book){
        books.add(book);
        buyNewBook(book);
    }

    public void buyNewBook(Book book){
        super.notifyObserver(book);
    }
}
