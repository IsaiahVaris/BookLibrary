package com.isaiahvaris;

import com.isaiahvaris.Model.*;

public class PriorityMain {
    public static void main(String[] args) {

        //Set queue implementation
        Library.setImplementation("Priority");

        //get the librarian
        Librarian librarian = Library.getLibrarian();
        //librarian populates the library with some books
        librarian.addBook("Effective Java", 3);
        librarian.addBook("java: a beginner’s guide", 2);
        librarian.addBook("The hitchhiker's guide To the galaxy");
        librarian.addBook("Things fall apart");
        librarian.addBook("New General Mathematics", 4);
        System.out.println();
        //Check current status of books in the library
        System.out.println(Library.getCurrentLibraryStatus());

        /*User are created(enter the library) and are successfully added to the queues
        if they are students or teachers allowed to use the library.
        Any user not allowed will be flagged and won't be added to the queue*/
        LibraryUser john = new LibraryUser("john","Modern Biology", "junior student");
        LibraryUser jane = new LibraryUser("jane", "Effective Java", "junior student");
        LibraryUser jack = new LibraryUser("jack", "Effective Java", "senior student");
        LibraryUser mondris = new LibraryUser("Mondris", "Effective Java", "ex-student");
        LibraryUser mary = new LibraryUser("mary","Things Fall Apart", "teacher");
        LibraryUser chika = new LibraryUser("chika","Java: A Beginner's Guide", "teacher");
        LibraryUser tolu = new LibraryUser("tolu","New General Mathematics", "junior student");
        LibraryUser lanre = new LibraryUser("lanre", "Effective Java", "teacher");
        LibraryUser bright = new LibraryUser("bright","The HitchHiker's Guide To The Galaxy", "senior student");
        System.out.println();

        //attend to all users on the queue
        librarian.attendToQueue(Library.getQueue());
        System.out.println();

        //Check current status of books in the library
        System.out.println(Library.getCurrentLibraryStatus());
    }
}
