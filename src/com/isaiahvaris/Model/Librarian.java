package com.isaiahvaris.Model;

import java.util.Queue;

public class Librarian {

    //Librarian can add a book to the library
    public void addBook (String book) {
        book = book.toUpperCase();
        if (Library.getBooks().containsKey(book)) {
            Library.getBooks().put(book, Library.getBooks().get(book) + 1);
        } else {
            Library.getBooks().put(book, 1);
        }
        System.out.println("One copy of " + book + " added to the library.");
    }

    //Librarian can add multiple copies of a book at a time
    public void addBook (String book, int quantity) {
        book = book.toUpperCase();
        if (Library.getBooks().containsKey(book)) {
            Library.getBooks().put(book, Library.getBooks().get(book) + quantity);
        } else {
            Library.getBooks().put(book, quantity);
        }
        System.out.println(quantity + " copies of " + book + " added to the library.");
    }

    //Librarian adds library users to a queue before attending to them
    public void addToQueue (LibraryUser user) {
        user.setQueueNumber(Library.getQueue().size());
        Library.getQueue().add(user);
    }

    //Attending to each user
    public void attendTo (LibraryUser user) {
        //Fulfil request if book user wants is present in the library
        if (Library.getBooks().containsKey(user.getBookRequest())) {
            System.out.println(user.getBookRequest() + " given to " + user.getName());
            //update library to reflect that one copy of a book has gone out
            Library.getBooks().put(user.getBookRequest(), Library.getBooks().get(user.getBookRequest()) - 1);
            //If there are no more copies of a book in the library it should be removed
            Library.getBooks().remove(user.getBookRequest(), 0);
        }

        //Request can't be fulfilled if book user wants is not present in the library
        else {
            System.out.println(user.getBookRequest() + " is not available in the library");
        }
    }

    //Librarian attends to all users after they've been added to the queue
    public void attendToQueue (Queue<LibraryUser> queue) {
        while (!queue.isEmpty()) {
            this.attendTo(queue.poll());
        }
    }
}