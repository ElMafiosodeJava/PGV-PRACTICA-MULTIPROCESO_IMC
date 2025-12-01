package net.salesianosLaCuesta.utils;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {

    // Ruta al programa que calcula el IMC
    private static final String OPERATIONS_ROUTE =
            "./src/net/salesianosLaCuesta/functions/ImcCalc.java";

    /**
     * Lanza un proceso de Java que ejecuta ImcCalc con la frase dada.
     * La salida estándar NO se redirige a fichero: se leerá desde App.
     */
    public static Process initOperation(String text) throws IOException {

        // Ejecutamos: java ./src/net/salesianosLaCuesta/functions/ImcCalc.java "Lunes,1.91,70.0"
        ProcessBuilder builder = new ProcessBuilder("java", OPERATIONS_ROUTE, text);

        // Redirigimos solo la salida de error a un fichero
        File errorFile = new File("./src/net/salesianosLaCuesta/outputs/errorFiles/error.txt");
        builder.redirectError(errorFile);

        // La salida estándar se queda en el InputStream del Process
        return builder.start();
    }
}
