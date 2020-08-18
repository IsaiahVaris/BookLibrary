package com.isaiahvaris.Model;

import java.util.*;
import java.util.function.Function;

public class Library {
    //Library has a collection of books...
    private static Map<String, Integer> books = new HashMap<>();

    //...a librarian in charge of the library...
    private static final Librarian librarian = new Librarian();

    //...a queue of users
    private static Queue<LibraryUser> queue;

    //Method to set the implementation of the queue
    public static void setImplementation(String implementation) {
        if ("FIFO".equals(implementation)) {
            //first in first out queue
            queue = new LinkedList<>();
        } else if ("Priority".equals(implementation)) {
            /*priority queue using custom comparator. If users have the same book request
             they should be attended to based on priority else attend to them based on a
             first come first serve basis of them joining the queue*/
            queue = new PriorityQueue<>((user1, user2) -> {
                return user1.getBookRequest().equals(user2.getBookRequest()) ?
                        Integer.compare(user1.getLevelNumber(), user2.getLevelNumber()) :
                        Integer.compare(user1.getQueueNumber(), user2.getQueueNumber());
            });
        }
        //error message if right implementation is not set
        else {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.err.println("Set \"Priority\" for priority queue implementation" +
                        " and \"FIFO\" for oridnary queue implementation");
            }
        }
    }

    //getters for library fields
    public static Map<String, Integer> getBooks() { return books; }

    public static Librarian getLibrarian() { return librarian; }

    public static Queue<LibraryUser> getQueue() { return queue; }

    //To check books currently available in the library and their quantity
    public static String getCurrentLibraryStatus() {
        if (books.isEmpty()) { return "There are no books in the library"; }

        String message = "There are " + books.size() + " different books in the library:\n";
        Function<Map.Entry<String, Integer>, String> bookStatus = entry ->
                entry.getValue() + " copy(ies) of " + entry.getKey() + "\n";

        return message + Library.books.entrySet().stream().map(bookStatus).reduce("", (a, b) -> a + b);
    }
}