package com.isaiahvaris.Model.Test;

import com.isaiahvaris.Model.Librarian;
import com.isaiahvaris.Model.Library;
import com.isaiahvaris.Model.LibraryUser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserComparatorTest {

    @Test
    void testCompare() {
        Library.setImplementation("Priority");
        Librarian librarian = Library.getLibrarian();
        LibraryUser jane = new LibraryUser("jane", "Effective Java", "junior student");
        LibraryUser jack = new LibraryUser("jack", "Effective Java", "senior student");
        LibraryUser lanre = new LibraryUser("lanre", "Effective Java", "teacher");

        //Book requests are the same so order in queue should follow priority not order of adding to the list
        assertEquals(lanre, Library.getQueue().poll());
        assertEquals(jack, Library.getQueue().poll());
        assertEquals(jane, Library.getQueue().poll());
    }
}