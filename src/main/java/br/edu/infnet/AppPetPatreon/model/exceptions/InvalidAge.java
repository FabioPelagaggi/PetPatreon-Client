package br.edu.infnet.AppPetPatreon.model.exceptions;

public class InvalidAge extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidAge(String message) {
        super("Invalid Age: " + message + ".");
    }
}
