package br.edu.infnet.AppPetPatreon;

import br.edu.infnet.AppPetPatreon.model.domain.Patreon;

public class PatreonTest {
    public static void main(String[] args) {
        try {
            Patreon patreon01 = new Patreon("Ernesto Alb3rtos", "ernesto@gmail.com", "552197621566");
            System.out.println(patreon01);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }
        
        try {
            Patreon patreon02 = new Patreon("Ferdinando Araujo de Maggida", "ferdinandinhogmail.com", "552378787878");
            System.out.println(patreon02);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }

        try {
            Patreon patreon03 = new Patreon("Ferdinando Araujo de Maggida", "ferdinan dinho@gmail.com", "552378787878");
            System.out.println(patreon03);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }

        try {
            Patreon patreon04 = new Patreon("Maria Arauja", "maria_lulu@gmail.com", "35AA199621886");
            System.out.println(patreon04);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }

        try {
            Patreon patreon05 = new Patreon("Maria Arauja", "maria_lulu@gmailcom", "35199621886");
            System.out.println(patreon05);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }

        try {
            Patreon patreon06 = new Patreon("Ernesto", "ernesto@gmail.com", "552197621566");
            System.out.println(patreon06);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[ERROR] - " + e.getMessage());
        }
    }
}