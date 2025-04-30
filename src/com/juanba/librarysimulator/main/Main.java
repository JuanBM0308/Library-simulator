package com.juanba.librarysimulator.main;

import com.juanba.librarysimulator.models.Book;
import com.juanba.librarysimulator.models.Library;
import com.juanba.librarysimulator.models.Magazine;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book book1 = new Book("Verde fue mi selva", "Edna Iturralde", "978-84-9916-901-9");
        Book book2 = new Book("El principito", "Antoine de Saint-Exupéry", "576-23-7642-543-6");
        Book book3 = new Book("Pie de Bruja (Carmina Nocturna 3)", "Carolina Andújar", "245-77-5436-976-0");
        Book book4 = new Book("Verde fue mi selva", "Edna Iturralde", "112-23-6547-005-4");

        Magazine magazine1 = new Magazine("El buen pintor", "Blue radio", 64);
        Magazine magazine2 = new Magazine("Farandula con Richie", "Vea", 66);
        Magazine magazine3 = new Magazine("La pasion del futbol", "Win Sports", 89);

        Library library = new Library();
        library.addMaterial(book1);
        library.addMaterial(book2);
        library.addMaterial(book3);
        library.addMaterial(book4);

        library.addMaterial(magazine1);
        library.addMaterial(magazine2);
        library.addMaterial(magazine3);

        System.out.println("\nMaterial disponible:");
        library.listMaterial();

        System.out.println("Digite el nombre del material a pedir prestado:");
        String petitionBook = scanner.nextLine();
        library.lendMaterial(petitionBook);

        library.listMaterial();

        System.out.println("Digite el ID del material a regresar:");
        String petitionReturn = scanner.nextLine();
        library.returnMaterial(petitionReturn);

        library.listMaterial();
    }
}
