package libraryservice;

import librarymodel.Person;

public class BookRequest {

    private final Person person;
    private final Book book;


    public BookRequest(Person person, Book book) {
        this.person = person;
        this.book = book;
    }

    public Person getPerson() {
        return person;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString(){
        return this.person.getName() + " " + this.book.getTitle();
    }
}
