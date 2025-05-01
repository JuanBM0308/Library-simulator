package com.juanba.librarysimulator.main;

import com.juanba.librarysimulator.models.Book;
import com.juanba.librarysimulator.models.Library;
import com.juanba.librarysimulator.models.Magazine;

import java.util.InputMismatchException;
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
        Magazine magazine4 = new Magazine("La pasion del futbol", "Win Sports", 90);

        Library library = new Library();
        library.addMaterial(book1);
        library.addMaterial(book2);
        library.addMaterial(book3);
        library.addMaterial(book4);

        library.addMaterial(magazine1);
        library.addMaterial(magazine2);
        library.addMaterial(magazine3);
        library.addMaterial(magazine4);

        System.out.println("\n***************************************************");
        System.out.println("* Bienvenido a 'Tu biblioteca online'      *");
        System.out.println("***************************************************");
        System.out.println("|    Opciones    |           Descripcion          |");
        System.out.println("|----------------|--------------------------------|");
        System.out.println("|       1        |        Listar materiales       |");
        System.out.println("|       2        |     Pedir material prestado    |");
        System.out.println("|       3        |    Regresar material prestado  |");
        System.out.println("|----------------|--------------------------------|");
        System.out.println("|       4        |       Cerrar el programa       |");
        System.out.println("--------------------------------------------------");

        int userOption;
        try {
            do {
                System.out.println("\nDigite su opcion deseada: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, ingrese un numero.");
                    scanner.next();
                }
                userOption = scanner.nextInt();
                scanner.nextLine();

                switch (userOption) {
                    case 1:
                        library.listMaterial();
                        break;
                    case 2:
                        System.out.println("\nDigite el nombre del material a pedir prestado:");
                        String petitionMaterial = scanner.nextLine();
                        library.lendMaterial(petitionMaterial);
                        break;
                    case 3:
                        System.out.println("Digite el ID del material a regresar:");
                        String petitionReturn = scanner.nextLine();
                        library.returnMaterial(petitionReturn);
                        break;
                    case 4:
                        System.out.println("Cerrando el programa. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("** Ingrese una opcion disponible **");
                }
            } while (userOption != 4);
        } catch (InputMismatchException e) {
            System.out.println("No se ha ingresado un numero de opcion correacto.");
        } finally {
            scanner.close();
        }
    }
}