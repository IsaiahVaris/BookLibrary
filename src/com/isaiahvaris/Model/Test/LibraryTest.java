package com.isaiahvaris.Model.Test;

import com.isaiahvaris.Model.Librarian;
import com.isaiahvaris.Model.Library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void testSetImplementation() {

        Library.setImplementation("Priority");
        //Priority implementation should set the queue to a priority queue
        assertEquals("class java.util.PriorityQueue", "" + Library.getQueue().getClass());

        Library.setImplementation("FIFO");
        //FIFO implementation should set the queue to a linkedlist
        assertEquals("class java.util.LinkedList", "" + Library.getQueue().getClass());
    }

    @Test
    void testGetCurrentLibraryStatus() {
        Librarian librarian = Library.getLibrarian();
        //Status should reflect that no books added to library yet
        assertEquals("There are no books in the library", Library.getCurrentLibraryStatus());

        librarian.addBook("Effective Java", 3);
        librarian.addBook("java: a beginner’s guide", 2);
        //Status should reflect books that have been added
        assertEquals("There are 2 different books in the library:\n" +
                "2 copy(ies) of JAVA: A BEGINNER’S GUIDE\n" +
                "3 copy(ies) of EFFECTIVE JAVA\n", Library.getCurrentLibraryStatus());
        Library.getBooks().clear();
    }
}