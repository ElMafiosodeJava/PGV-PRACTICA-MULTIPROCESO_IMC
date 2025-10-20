package net.salesianosLaCuesta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
            final String INPUT_ROUTE = "./src/net/salesianosLaCuesta/inputs/imc.txt";

        ArrayList<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_ROUTE, StandardCharsets.UTF_8))) {
            String currentLine = reader.readLine();
            while (currentLine != null) {
                phrases.add(currentLine);
                currentLine = reader.readLine();
            }
            phrases.remove(0);
            reader.close();
        } catch (Exception e) {
            System.out.println("Error: no se puede extraer el contenido de: " + INPUT_ROUTE);
        }

    }
}
