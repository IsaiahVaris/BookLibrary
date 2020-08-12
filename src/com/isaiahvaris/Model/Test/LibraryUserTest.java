package com.isaiahvaris.Model.Test;

import com.isaiahvaris.Model.Librarian;
import com.isaiahvaris.Model.Library;
import com.isaiahvaris.Model.LibraryUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUserTest {
    @Test
    void testLibraryUser() {
        Library.setImplementation("Priority");
        Librarian librarian = Library.getLibrarian();
        LibraryUser jerry = new LibraryUser("Jerry", "Effective Java", "ex-student");
        LibraryUser mary = new LibraryUser("mary","Things Fall Apart", "teacher");
        //user mary should be created succeefully
        assertEquals("mary", mary.getName());
        assertEquals("THINGS FALL APART", mary.getBookRequest());
        assertEquals("teacher", mary.getLevel());
        assertEquals(1, mary.getLevelNumber());
        assertEquals(0, mary.getQueueNumber());
        //jerry "ex-student" is not allowed to use the library so should not be created
        assertNull(jerry.getName());
    }
}