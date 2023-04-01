package br.edu.infnet.AppPetPatreon.model.exceptions;

public class InvalidName extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidName(String message) {
        super("Invalid Name: " + message + ".");
    }
}
