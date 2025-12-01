package net.salesianosLaCuesta.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    private static final String INPUT_ROUTE =
            "./src/net/salesianosLaCuesta/inputs/imc.txt";

    private static final Path OUTPUT_ROUTE =
            Paths.get("./src/net/salesianosLaCuesta/outputs/resultFiles/imcCalc.txt");

    /**
     * Lee el fichero imc.txt, salta la cabecera y devuelve
     * las líneas con datos en una lista.
     */
    public ArrayList<String> leerDocumento() throws IOException {

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_ROUTE))) {
            String line;
            boolean first = true; // para saltar "DIA,ALTURA,PESO"

            while ((line = br.readLine()) != null) {
                if (first) {
                    first = false; // saltamos cabecera
                    continue;
                }

                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        }

        return lines;
    }

    public void deleteIfExist() throws IOException {

        if (Files.exists(OUTPUT_ROUTE)) {
            Files.delete(OUTPUT_ROUTE);
        }
    }

    /**
     * Escribe en imcCalc.txt todas las líneas recibidas, en orden.
     * Crea la carpeta de salida si no existe.
     */
    public void escribirResultadosOrdenados(List<String> lineas) throws IOException {

        // Nos aseguramos de que existe la carpeta ./outputs/resultFiles
        Path parent = OUTPUT_ROUTE.getParent();
        if (parent != null && !Files.exists(parent)) {
            Files.createDirectories(parent);
        }

        Files.write(
                OUTPUT_ROUTE,
                lineas,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }
}
