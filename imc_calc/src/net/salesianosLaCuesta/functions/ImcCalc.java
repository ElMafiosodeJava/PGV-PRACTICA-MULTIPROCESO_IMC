package net.salesianosLaCuesta.functions;

public class ImcCalc {
    
    public static void main(String[] args) {
        String phrase = args[0];

        String[] words = phrase.split(",");

        if (args.length > 1) {
            return;
        }

        String day = words[0];
        String height = words[1];
        String weight = words[2];

        float imc = Float.parseFloat(weight) / (Float.parseFloat(height) * 2) ;

        System.out.println("El día " + day + " ,el cliente Marco con una altura de "+ height + " un peso de "+ weight +" tiene un IMC de: " + imc);

    }
}
