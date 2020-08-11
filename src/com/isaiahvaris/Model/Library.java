package com.isaiahvaris.Model;

import java.util.*;

public class Library {
    //Library has a collection of books...
    private static Map<String, Integer> books = new HashMap<>();

    //...a librarian in charge of the library
    private static final Librarian librarian = new Librarian();

    private static Queue<LibraryUser> queue;

    //...a first come first serve queue of library users...
//    private static Queue<LibraryUser> queue = new PriorityQueue<>(new UserComparator());

    public static void setImplementation(String implementation) {
        if ("FIFO".equals(implementation)) {
            queue = new LinkedList<>();
        }
        if ("Priority".equals(implementation)) {
            queue = new PriorityQueue<>(new UserComparator());
        }
    }

    //getters for library fields
    public static Map<String, Integer> getBooks() { return books; }

    public static Librarian getLibrarian() { return librarian; }

    public static Queue<LibraryUser> getQueue() { return queue; }

    //To check books currently available in the library and their quantity
    public static void getCurrentLibraryStatus() {
        System.out.println("There are " + books.size() + " different books in the library:");
        for (Map.Entry<String, Integer> entry : books.entrySet()) {
            System.out.println(entry.getValue() + " copy(ies) of " + entry.getKey());
        }
    }
}
//Comparator for populating the library priority queue
class UserComparator implements Comparator<LibraryUser> {
    @Override
    public int compare(LibraryUser user1, LibraryUser user2) {
        if (user1.getBookRequest().equals(user2.getBookRequest())) {
            return Integer.compare(user1.getLevelNumber(), user2.getLevelNumber());
        }
        return Integer.compare(user1.getQueueNumber(), user2.getQueueNumber());
    }
}