package net.salesianosLaCuesta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import net.salesianosLaCuesta.utils.FileHelper;
import net.salesianosLaCuesta.utils.ProcessLauncher;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        FileHelper fileHelper = new FileHelper();

        // 1. Leemos las líneas del fichero imc.txt (sin la cabecera)
        ArrayList<String> phrases = fileHelper.leerDocumento();

        // 2. Borramos el fichero de salida si existe de ejecuciones anteriores
        fileHelper.deleteIfExist();

        // 3. Lanzamos todos los procesos en paralelo
        ArrayList<Process> processes = new ArrayList<>();

        for (String phrase : phrases) {
            Process subProcess = ProcessLauncher.initOperation(phrase);
            processes.add(subProcess);
        }

        // 4. Recogemos la salida de cada proceso EN EL MISMO ORDEN
        ArrayList<String> resultados = new ArrayList<>();

        for (Process process : processes) {
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {

                // Cada ImcCalc escribe una única línea
                String line = br.readLine();
                if (line != null) {
                    resultados.add(line);
                } else {
                    resultados.add("Proceso sin salida");
                }
            }

            // Nos aseguramos de que el proceso ha terminado
            process.waitFor();
        }

        // 5. Escribimos todas las líneas ordenadas en imcCalc.txt
        fileHelper.escribirResultadosOrdenados(resultados);
    }
}
