package br.edu.infnet.AppPetPatreon.model.validation;

import br.edu.infnet.AppPetPatreon.constants.CONST;
import br.edu.infnet.AppPetPatreon.model.exceptions.InvalidAge;
import br.edu.infnet.AppPetPatreon.model.exceptions.InvalidCost;
import br.edu.infnet.AppPetPatreon.model.exceptions.InvalidEmail;
import br.edu.infnet.AppPetPatreon.model.exceptions.InvalidName;
import br.edu.infnet.AppPetPatreon.model.exceptions.InvalidPhone;

public class Valid {

    public static String name(String input) throws Exception {
        char[] chars = input.toCharArray();
        StringBuilder intList = new StringBuilder();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                intList.append(c);
            }
        }

        if (intList.length() == 0) {
            return input;
        } else {
            throw new InvalidName("The name must contain only digits");
        }
    }

    public static String email(String input) throws Exception {
        char[] chars = input.toCharArray();
        StringBuilder charsList = new StringBuilder();

        for (char c : chars) {
            if (!Character.isWhitespace(c)) {
                charsList.append(c);
            } else {
                throw new InvalidEmail("The Email must not contain whitespace");
            }
        }
        if (!charsList.toString().contains("@")) {
            throw new InvalidEmail("The Email must contain at sign");
        }
        if (!charsList.toString().contains(".com")) {
            throw new InvalidEmail("The Email must contain '.com'");
        }
        return input;
    }

    public static String phone(String input) throws Exception {
        char[] chars = input.toCharArray();
        StringBuilder charList = new StringBuilder();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                charList.append(c);
            }
        }

        if (charList.length() == 0) {
            return input;
        } else {
            throw new InvalidPhone("The phone must contains only digits");
        }
    }

    public static int age(int input) throws Exception {
        if (input <= 0) {
            throw new InvalidAge("The age must be greater than 0");
        } else if (input >= CONST.MAX_AGE) {
            throw new InvalidAge("The age must be less than " + CONST.MAX_AGE);
        }
        return input;
    }

    public static float cost(float input) throws Exception {
        if (input <= 0) {
            throw new InvalidCost("The food cost must be greater than 0");
        } else if (input >= CONST.MAX_COST) {
            throw new InvalidCost("The food cost must be less than " + CONST.MAX_COST);
        }
        return input;
    }
}
