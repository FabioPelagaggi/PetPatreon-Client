package br.edu.infnet.AppPetPatreon.model.exceptions;

public class InvalidPhone extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidPhone(String message) {
        super("Invalid Phone: " + message + ".");
    }
}
