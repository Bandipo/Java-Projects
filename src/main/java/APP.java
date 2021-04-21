import librarymodel.Person;
import libraryservice.Book;
import libraryservice.BookRequest;
import libraryservice.Library;

public class APP {
    public static void main(String[] args) {

        Library lib = new Library();

        Book android = new Book("Android", "Taiwo", "1234");
        Book book2 = new Book("Java", "Taiwo", "1235");


        lib.addBooks(android,6);
        lib.addBooks(book2, 3);







        Person teacher = new Person("Teacher Taiwo","Teacher");
        Person student = new Person("Senior Taiwo", "Senior");
        Person juniorStudent = new Person("Junior","Junior" );


        BookRequest bookRequest1 = new BookRequest(juniorStudent,android);
        BookRequest bookRequest3 = new BookRequest(teacher,android);
        BookRequest bookRequest2 = new BookRequest(student,android);





        lib.addRequest(bookRequest1);//Junior student asks for "Android"
        lib.addRequest(bookRequest2);//Senior student asks for "Android"
        lib.addRequest(bookRequest3);//Teacher asks for "Android"

        //Without Priority
        System.out.println("Without Priority");
        lib.borrowBook();

        // add priority
        lib.addPriority();
        System.out.println();
        System.out.println("By Priority: ");
        System.out.println(lib.getPriorityQueue());
        System.out.println();// to add space;
        lib.borrowByPriority();







    }
}
