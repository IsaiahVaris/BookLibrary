package com.isaiahvaris.Model;

public class LibraryUser {
    private String name;
    private String bookRequest;
    private String level;
    private int levelNumber;
    private int queueNumber;

    public LibraryUser(String name, String bookRequest, String level) {
        level = level.toLowerCase();
        /*Check if user level is allowed before initializing(allowing user into the library)
        Anyone who isn't a student or a teacher shouldn't be allowed to use the library*/
        if (!("junior student".equals(level) || "senior student".equals(level) || "teacher".equals(level))) {
            System.err.println((name + " cannot use Library. " +
                    "User must be either a junior or senior student or a teacher\n").toUpperCase());
            return;
        }
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
        Library.getLibrarian().addToQueue(this);
    }

    //getters for user fields
    public String getName() {
        return name;
    }

    public String getBookRequest() {
        return bookRequest;
    }

    public String getLevel() {
        return level;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getQueueNumber() { return queueNumber; }

    public void setQueueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }
}
