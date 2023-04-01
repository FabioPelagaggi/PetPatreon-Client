package br.edu.infnet.AppPetPatreon.model.exceptions;

public class InvalidEmail extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidEmail(String message) {
        super("Invalid Email: " + message + ".");
    }
}
