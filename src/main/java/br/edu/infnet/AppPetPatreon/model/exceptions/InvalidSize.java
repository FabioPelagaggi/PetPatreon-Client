package br.edu.infnet.AppPetPatreon.model.exceptions;

public class InvalidSize extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidSize(String message) {
        super("Invalid Size: " + message + ".");
    }
}
