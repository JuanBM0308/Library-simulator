package com.juanba.librarysimulator.models;

public class Book extends LibraryMaterial {
    private final String isbn;

    public Book(String title, String author, String isbn) {
        super(title, author);
        this.isbn = isbn;
    }

    @Override
    public String showInformation() {
        return "\n+----------- LIBRO -----------+" +
                "\nIsbn: " + this.isbn+
                "\nTítulo: " + getTitle() +
                "\nAutor: "+ getAuthor() +
                "\n+-----------------------------+" +
                "\n";
    }

    @Override
    public void lendLibraryMaterial(String title) {
        super.lendLibraryMaterial(title);
        System.out.println("La biblioteca te presta el libro, cuida bien de (" + title + ")");
    }

    @Override
    public void returnLibraryMaterial(String title) {
        super.returnLibraryMaterial(title);
        System.out.println("Esperamos hayas disfrutado del libro (" + title + ")");
    }
}
