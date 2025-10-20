package net.salesianosLaCuesta.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileHelper {

    public ArrayList<String> leerDocumento() throws IOException {

        final String INPUT_ROUTE = "./src/net/salesianosLaCuesta/inputs/imc.txt";

        deleteIfExist();
        
        ArrayList<String> phrases = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_ROUTE, StandardCharsets.UTF_8))) {
            String currentLine = reader.readLine();
            while (currentLine != null && currentLine.equals("") != false) {
                currentLine = reader.readLine();
                phrases.add(currentLine);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("No se pudo acceder al documento.");
            return null;
        }

        return phrases;

    }

    public void deleteIfExist() throws IOException{

        final Path OUT_PUT_ROUTE = Path.of("./src/net/salesianosLaCuesta/outputs/resultFiles/imcCalc.txt");

        if (OUT_PUT_ROUTE.toFile().exists()) {
            Files.delete(OUT_PUT_ROUTE);
        }

    }

    
}
