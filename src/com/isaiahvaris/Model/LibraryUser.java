package com.isaiahvaris.Model;

import java.util.function.Predicate;

public class LibraryUser {
    private String name;
    private String bookRequest;
    private String level;
    private int levelNumber;
    private int queueNumber;

    public LibraryUser(String name, String bookRequest, String level) {
        level = level.toLowerCase();
         //Check if user level is allowed before initializing(allowing user into the library)
        Predicate<String> isValidLevel = n -> "junior student".equals(n) || "senior student".equals(n) || "teacher".equals(n);
        if (isValidLevel.test(level)) {
            this.level = level;
            this.name = name.toLowerCase();
            this.bookRequest = bookRequest.toUpperCase();
            //level number is set based on user level
            switch (level) {
                case "teacher":
                    this.levelNumber = 1;
                    break;
                case "senior student":
                    this.levelNumber = 2;
                    break;
                default:
                    this.levelNumber = 3;
            }
            //User is added to queue by the librarian as he/she is created (as user enters the library)
            Library.getLibrarian().addToQueue.accept(this);
        }
        //Anyone who isn't a student or a teacher shouldn't be allowed to use the library
        else {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.err.println((name + " cannot use Library. " +
                        "User must be either a junior or senior student or a teacher\n").toUpperCase());
            }
        }
    }

    //getters for user fields
    public String getName() { return name; }

    public String getBookRequest() { return bookRequest; }

    public String getLevel() { return level; }

    public int getLevelNumber() { return levelNumber; }

    public int getQueueNumber() { return queueNumber; }

    public void setQueueNumber(int queueNumber) { this.queueNumber = queueNumber; }
}
