package libraryservice;

import librarymodel.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library lib = new Library();
    Book android;


    @BeforeEach
    void setUp() {
        Book android = new Book("Android", "Taiwo", "1234");
        Person teacher = new Person("Teacher Taiwo","Teacher");
        Person student = new Person("Senior Taiwo", "Senior");
        Person juniorStudent = new Person("Junior","Junior" );


        BookRequest  bookRequest1 = new BookRequest(juniorStudent,android);
        lib.addRequest(bookRequest1);
        lib.addBooks(android,2);
        lib.addPriority();
    }


    @Test
    void addBooks() {
        assertEquals(lib.getLibraryBooks().size(), 1);
    }

    @Test
    void addRequest() {
        Person student = new Person("Senior Taiwo", "Senior");
        BookRequest  bookRequest1 = new BookRequest(student,android);
        lib.addRequest(bookRequest1);
        assertTrue(lib.getBookRequestQueue().size()>0);
    }

    @Test
    void borrowBook() {
        assertTrue(lib.getLibraryBooks().size()>0);
    }

    @Test
    void addPriority() {
        assertTrue(lib.getPriorityQueue().size()>0);
    }

    @Test
    void borrowByPriority() {
        assertEquals("Android",lib.getPriorityQueue().peek().getBook().getTitle());
    }
}