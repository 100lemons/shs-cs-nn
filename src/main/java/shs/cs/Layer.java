package shs.cs;

/*class that represents layer of neurons in neural net*/

/*Represents layer of neurons in neural network*/
public class Layer {
    private Neuron[] neurons;

    /*Constructor to create layer with specified number of neurons*/
    public Layer(int neuronCount, int inputCount) {
        this.neurons = new Neuron[neuronCount];
        for (int i = 0; i < neuronCount; i++) {
            neurons[i] = new Neuron(inputCount);
        }
    }

    /*calculate output of neuron based on inputs*/
    public double[] output(double[] inputs) {
        double[] res = new double[neurons.length];
        for (int i = 0; i < neurons.length; i++) {
            res[i] = neurons[i].output(inputs);
        }
        return res;
    }

}
