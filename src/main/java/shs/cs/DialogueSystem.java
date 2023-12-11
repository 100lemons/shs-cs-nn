package shs.cs;

import java.util.Random;
import java.util.Scanner;
public class DialogueSystem {
    private static Random rand = new Random();

    /*Simple application of neural networks to demonstrate basic dialogue system*/

    public static void main(String[] args) {
        //entry point of application
        /*Initializes the neural network.
        Reads user input and processes it through the network.
        Generates a response based on the network's output*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your sentence, then hit enter:");
        String test = scanner.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test.length(); i++) {
            String res = generateResponse(encodeUserInput(test.substring(i, i + 1)));
            sb.append(res);
        }
        System.out.println("input String: " + test + ", predicted String: " + sb.toString());
    }

    private static double[] encodeUserInput(String input) {
        double[] res = new double[1];
        res[0] = input.charAt(0);
        return res;
    }


    /*Generates response based on neural network's output*/
    private static String generateResponse(double[] intent) {
        /*Determines the response based on the highest value in the intent array
        (representing the network's output). Create 3-4 responses of your own to choose from as an output.*/
        int layerCount = rand.nextInt(8) + 3;
        int[] layerSizes = new int[layerCount];

        layerSizes[0] = intent.length; // first layer is input layer, match input size
        for (int i = 1; i < layerCount - 1; i++) {
            layerSizes[i] = rand.nextInt(20) + 1;
        }
        layerSizes[layerCount - 1] = 26; // last layer is 26, each for one of the 26 characters

        Network nn = new Network(1, layerSizes);
        double[] res = nn.output(intent);

        double max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > max) {
                max = res[i];
                maxIndex = i;
            }
        }
//        System.out.println("output: " + Arrays.toString(res));
//        System.out.println("max: " + max + ", maxIndex: " + maxIndex);
        char c = (char) ('a' + maxIndex);
        return String.valueOf(c);
    }


}
