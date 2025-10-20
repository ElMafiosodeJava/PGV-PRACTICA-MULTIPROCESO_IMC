package net.salesianosLaCuesta.utils;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {

    private static final String OPERATIONS_ROUTE = "./src/net/salesianosLaCuesta/functions/ImcCalc.java";

    public static Process initOperation(String text, String outputFileName) throws IOException {
        
        ProcessBuilder builder = new ProcessBuilder("java", OPERATIONS_ROUTE, text);
        File outputFile = new File("./src/net/salesianosLaCuesta/outputs/resultFiles/" + outputFileName);
        File errorFile = new File("./src/net/salesianosLaCuesta/outputs/errorFiles/error.txt");
        
        builder.redirectOutput(ProcessBuilder.Redirect.appendTo(outputFile));
        builder.redirectError(errorFile);
        
        return builder.start();

    }
}
