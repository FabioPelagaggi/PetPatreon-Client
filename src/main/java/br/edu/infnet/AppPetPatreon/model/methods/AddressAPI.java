package br.edu.infnet.AppPetPatreon.model.methods;

import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import br.edu.infnet.AppPetPatreon.model.domain.Address;

public class AddressAPI {

    public static Address requestAddress(String cep) {
        try {
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder jsonAddress = new StringBuilder();

            while (scanner.hasNext()) {
                jsonAddress.append(scanner.next());
            }

            scanner.close();
            connection.disconnect();

            Address address = new Gson().fromJson(jsonAddress.toString(), Address.class);

            return address;
        } catch (Exception e) {
            return null;
        }
    }

}