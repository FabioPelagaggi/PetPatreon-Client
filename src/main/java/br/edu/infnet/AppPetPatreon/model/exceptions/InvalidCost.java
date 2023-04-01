package br.edu.infnet.AppPetPatreon.model.exceptions;

public class InvalidCost extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidCost(String message) {
        super("Invalid Cost: " + message + ".");
    }
}
