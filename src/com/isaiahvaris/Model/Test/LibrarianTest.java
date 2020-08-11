package com.isaiahvaris.Model.Test;

import com.isaiahvaris.Model.Librarian;
import com.isaiahvaris.Model.Library;
import com.isaiahvaris.Model.LibraryUser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {

    @Test
    void testAddMultipleBooks() {
        Librarian librarian = Library.getLibrarian();
        librarian.addBook("Effective Java", 3);
        assertEquals(3, Library.getBooks().get("Effective Java".toUpperCase()));
    }

    @Test
    void testAddBook() {
        Librarian librarian = Library.getLibrarian();
        librarian.addBook("Things Fall Apart");
        assertEquals(1, Library.getBooks().get("Things Fall Apart".toUpperCase()));
    }

    @Test
    void testAddToQueue() {
        Library.setImplementation("Priority");
        LibraryUser jane = new LibraryUser("jane", "Harry Potter", "junior student");
        LibraryUser jack = new LibraryUser("jack", "Fault In Our Stars", "senior student");

        assertEquals(0, jane.getQueueNumber());
        assertEquals(1, jack.getQueueNumber());
    }

    @Test
    void testAttendTo() {
        Library.setImplementation("Priority");
        Librarian librarian = Library.getLibrarian();
        LibraryUser john = new LibraryUser("john", "Computer Science is Easy", "junior student");
        librarian.addBook("Computer Science is Easy", 2);
        librarian.attendTo(john);

        assertEquals(1, Library.getBooks().get("Computer Science is Easy".toUpperCase()));
        assertNull(Library.getBooks().get("Non existent book"));
    }
}