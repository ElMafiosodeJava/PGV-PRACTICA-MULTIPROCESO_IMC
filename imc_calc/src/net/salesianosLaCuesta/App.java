package net.salesianosLaCuesta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import net.salesianosLaCuesta.utils.ProcessLauncher;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
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
