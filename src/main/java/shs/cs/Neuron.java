package shs.cs;

import java.util.Random;

public class Neuron {
    /*Represents single neuron in neural network*/

    private double[] weights;
    private double bias;
    private int inputCount;

    private Random rand = new Random();

    /*Constructor to initialize neuron with specific number of inputs*/
    public Neuron(int inputCount) {
        /*Purpose: Constructor initialize neuron with specific number of inputs.
        How it Works:
            1. Creates an array of weights, one for each input.
            2. Initializes each weight with a random value.
            3. Initializes the bias with a random value.
         */
        this.inputCount = inputCount;
        this.weights = new double[inputCount];
        for (int i = 0; i < inputCount; i++) {
            this.weights[i] = rand.nextDouble();
        }
        this.bias = rand.nextDouble();
    }

    /*Calculate output of neuron based on inputs. Contains sigmoid function*/
    public double output(double[] inputs) {
        double res = 0.0;
        for (int i = 0; i < weights.length; i++) {
            res = weights[i] * inputs[i];
        }
        res = sigmoid(res + bias);
        return res;
    }

    /*Transforms input to a value between 0 and 1, which is useful for binary classification*/
    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }


}
