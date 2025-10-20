package net.salesianosLaCuesta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import net.salesianosLaCuesta.utils.FileHelper;
import net.salesianosLaCuesta.utils.ProcessLauncher;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
    
    FileHelper file = new FileHelper();

    ArrayList <String> phrases = file.leerDocumento();

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
