package com.juanba.librarysimulator.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<LibraryMaterial> inventory;

    public Library() {
        this.inventory = new ArrayList<>();
    }

    public void addMaterial(LibraryMaterial material) {
        this.inventory.add(material);
        System.out.println("Material agregado con exito: " + material.getTitle());
    }

    public void lendMaterial(String title) {
        List<LibraryMaterial> availableMatches = inventory.stream()
                .filter(material -> material.getTitle().equals(title) && !material.isOnLoan())
                .toList();

        if (availableMatches.isEmpty()) {
            List<LibraryMaterial> allMatches = inventory.stream()
                    .filter(material -> material.getTitle().equals(title))
                    .toList();
            if (allMatches.isEmpty()) {
                System.out.println("\nNo se encontro ningun material con el titulo: (" + title + ")");
            } else  {
                System.out.println("\nTodos los materiales con el titulo (" + title + ") estan actualmente prestados.");
            }
        } else if (availableMatches.size() == 1) {
            LibraryMaterial materialToLend = availableMatches.getFirst();
            materialToLend.lendLibraryMaterial(title);
        } else {
            System.out.println("\nSe encontraron varias copias disponibles del mismo titulo: (" + title + ")");
            for (int i = 0; i < availableMatches.size(); i++) {
                System.out.println((i + 1) + ". " + availableMatches.get(i).showInformation());
            }

            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("Por favor, ingrese el numero de la copia que desea pedir prestada: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, ingrese un numero.");
                    scanner.next();
                }
                choice = scanner.nextInt();
            } while (choice < 1 || choice > availableMatches.size());

            LibraryMaterial selectedMaterial = availableMatches.get(choice - 1);
            selectedMaterial.lendLibraryMaterial(title);
        }
    }

    public void returnMaterial(String uniqueId) {
        boolean found = false;
        for (LibraryMaterial material : inventory) {
            String materialId = "";
            if (material instanceof Book) {
                materialId = ((Book) material).getIsbn();
            } else if (material instanceof Magazine) {
                materialId = String.valueOf(((Magazine) material).getNumber());
            }

            if (materialId.equals(uniqueId)) {
                found = true;
                if (material.isOnLoan()) {
                    material.returnLibraryMaterial(material.getTitle());
                } else {
                    System.out.println("\nEL material con ID: " + uniqueId + ", titulo: " + material.getTitle() + " no estaba en prestamo.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("\nNo se encontro ningún material con el ID: " + uniqueId + "\n");
        }
    }

    public void listMaterial() {
        for (LibraryMaterial material : inventory) {
            if (!material.isOnLoan()) {
                System.out.println(material.showInformation());
            }
        }
    }
}
