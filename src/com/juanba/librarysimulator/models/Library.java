package com.juanba.librarysimulator.models;

import java.util.ArrayList;
import java.util.List;

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
        boolean found = false;
        for (LibraryMaterial material : inventory) {
            if (material.getTitle().equals(title)) {
                found = true;
                if (!material.isOnLoan()) {
                    material.lendLibraryMaterial(title);
                } else {
                    System.out.println("\nEl material " + material.getTitle() + " ya está prestado.\n");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("\nNo se encontro ningún material con el título: " + title + "\n");
        }
    }

    public void returnMaterial(String title) {
        boolean found = false;
        for (LibraryMaterial material : inventory) {
            if (material.getTitle().equals(title)) {
                found = true;
                if (material.isOnLoan()) {
                    material.returnLibraryMaterial(title);
                } else {
                    System.out.println("\nEl material (" + material.getTitle() + ") no está en prestamos.\n");
                }
            }
        }
        if (!found) {
            System.out.println("\nNo se encontro ningún material con el título: " + title + "\n");
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
