package net.salesianosLaCuesta;

import java.io.IOException;

import java.util.ArrayList;

import net.salesianosLaCuesta.utils.FileHelper;
import net.salesianosLaCuesta.utils.ProcessLauncher;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
    
        
    FileHelper file = new FileHelper();

    ArrayList <String> phrases = file.leerDocumento();

    ArrayList<Process> phraseSubProcess = new ArrayList<>();

        for (int i = 0; i < phrases.size() - 1; i++) {
            Process subProcess = ProcessLauncher.initOperation(phrases.get(i), "imcCalc.txt");
            phraseSubProcess.add(subProcess);
        }

        for (Process process : phraseSubProcess) {
            process.waitFor();  
        }

    }
}
