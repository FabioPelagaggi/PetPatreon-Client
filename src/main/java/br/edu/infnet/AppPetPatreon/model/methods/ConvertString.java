package br.edu.infnet.AppPetPatreon.model.methods;

public class ConvertString {

    public static int toInt(String input) throws Exception {
        int intNum = 0;

        try {
            intNum = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return intNum;
    }

    public static float toFloat(String input) throws Exception {
        float floatNum = 0f;

        try {
            floatNum = Float.parseFloat(input);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return floatNum;
    }

}
