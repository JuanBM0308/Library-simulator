package com.juanba.librarysimulator.models;

public class Magazine extends LibraryMaterial {
    private final int number;

    public Magazine(String title, String author, int number) {
        super(title, author);
        this.number = number;
    }

    @Override
    public String showInformation() {
        return "\n+----------- REVISTA -----------+" +
                "\nNumero de revista: " + this.number+
                "\nTítulo: " + getTitle() +
                "\nAutor: "+ getAuthor() +
                "\n+-------------------------------+" +
                "\n";
    }

    @Override
    public void lendLibraryMaterial(String title) {
        super.lendLibraryMaterial(title);
        System.out.println("La biblioteca te presta la revista, cuida bien de (" + title + ")");
    }

    @Override
    public void returnLibraryMaterial(String title) {
        super.returnLibraryMaterial(title);
        System.out.println("Esperamos hayas disfrutado de la revista (" + title + ")");
    }

    public int getNumber() {
        return number;
    }
}
