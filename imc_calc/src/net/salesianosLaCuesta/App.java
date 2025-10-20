package net.salesianosLaCuesta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import net.salesianosLaCuesta.utils.ProcessLauncher;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        final String INPUT_ROUTE = "./src/net/salesianosLaCuesta/inputs/imc.txt";

        final Path OUT_PUT_ROUTE = Path.of("./src/net/salesianosLaCuesta/outputs/resultFiles/imcCalc.txt");
        
        if (OUT_PUT_ROUTE.toFile().exists()) {
            Files.delete(OUT_PUT_ROUTE);
        }
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
        }

    ArrayList<Process> phraseSubProcess = new ArrayList<>();
        for (int i = 0; i < phrases.size(); i++) {
            Process subProcess = ProcessLauncher.initOperation(phrases.get(i), "imcCalc.txt");
            phraseSubProcess.add(subProcess);
        }

        for (Process process : phraseSubProcess) {
            process.waitFor();  
        }

    }
}
