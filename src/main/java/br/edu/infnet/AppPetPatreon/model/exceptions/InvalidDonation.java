package br.edu.infnet.AppPetPatreon.model.exceptions;

public class InvalidDonation extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidDonation(String message) {
        super("Invalid Donation: " + message + ".");
    }

}
