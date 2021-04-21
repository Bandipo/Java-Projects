package libraryservice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Library {
    private final Map<Book, Integer> libraryBooks = new HashMap<Book, Integer>();
    private final Queue<BookRequest> bookRequestQueue = new PriorityQueue<>((BookRequest o1, BookRequest o2) -> 0);

    private final Queue<BookRequest> priorityQueue = new PriorityQueue<>((BookRequest main, BookRequest con)-> Integer.compare(con.getPerson().getPriorityLevel(), main.getPerson().getPriorityLevel()));


    /**
     *
     * @param book: Book to be added
     * @param noOfCopy: book copies
     */
    public void addBooks(Book book, int noOfCopy) {
        libraryBooks.put(book, noOfCopy);

    }





    /**
     *
     *
     * @param bookRequest: book Request to be added to bookRequestQueue
     */

    public void addRequest(BookRequest bookRequest) {
        bookRequestQueue.add(bookRequest);
    }


    public void borrowBook() {
        bookRequestQueue.forEach(bookRequest -> {
            if (libraryBooks.get(bookRequest.getBook()) > 0) {
                libraryBooks.put(bookRequest.getBook(), libraryBooks.get(bookRequest.getBook()) - 1);
                System.out.println("-".repeat(20) + "\nBook ' " + bookRequest.getBook().getTitle() + " ' Approved To: \n" +
                        "Name: " + bookRequest.getPerson().getName() + "\n" +
                        "Position: " + bookRequest.getPerson().getPosition());

            } else {
                System.out.println("\n  sorry, " + bookRequest.getPerson().getName() + " This book is limited");
            }

        });

    }


    public void addPriority(){
        priorityQueue.addAll(bookRequestQueue);
        BookRequest headRequest = priorityQueue.peek();
        bookRequestQueue.remove(headRequest);
    }

    public void borrowByPriority(){

        priorityQueue.forEach(bookRequest -> {
                    if (priorityQueue.isEmpty()) {
                        System.out.println("The Queue is empty");

                    }else {
                        System.out.format("-".repeat(20)+"\nPosition: %s\n Name: %s \n Book Borrowed: %s \n",
                                bookRequest.getPerson().getPosition(),
                                bookRequest.getPerson().getName(),
                                bookRequest.getBook().getTitle());
                    }
                }
        );

    }


    public Map<Book, Integer> getLibraryBooks() {
        return libraryBooks;
    }

    public Queue<BookRequest> getBookRequestQueue() {
        return bookRequestQueue;
    }

    public Queue<BookRequest> getPriorityQueue() {
        return priorityQueue;
    }
}
