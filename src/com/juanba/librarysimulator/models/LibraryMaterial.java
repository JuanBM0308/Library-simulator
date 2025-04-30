package com.juanba.librarysimulator.models;

public class LibraryMaterial {
    private String title;
    private String author;
    private boolean isOnLoan;

    public LibraryMaterial(String title, String author) {
        this.title = title;
        this.author = author;
        this.isOnLoan = false;
    }

    public void lendLibraryMaterial(String title) {
        this.isOnLoan = true;
    }

    public void returnLibraryMaterial(String title) {
        this.isOnLoan = false;
    }

    public String showInformation() {
        return "\nTítulo: " + this.title +
                "\nAutor: "+ this.author + "\n";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isOnLoan() {
        return isOnLoan;
    }
}
