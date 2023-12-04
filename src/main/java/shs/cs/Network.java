package shs.cs;
public class Network {

    //represents entire neural net, consisting of mult. layers
    /*Constructor to create neural network with specified layers*/
    private Layer[] layers;
    private int[] layerSizes;

    /**
     *
     * @param inputSize, the size of input layer
     * @param layerSizes, the size of each layer
     */
    public Network(int inputSize, int[] layerSizes) {
        // check to make sure inputSize matches the first layer size, otherwise, report error
        if (inputSize != layerSizes[0]) {
            throw new RuntimeException("input size " + inputSize + " does not match first layer (input layer) size " + layerSizes[0]);
        }
        this.layerSizes = layerSizes;
        layers = new Layer[layerSizes.length];
        for (int i = 0; i < layerSizes.length; i++) {
            if (i == 0) {
                layers[i] = new Layer(layerSizes[i], inputSize);
            } else {
                layers[i] = new Layer(layerSizes[i], layerSizes[i-1]);
            }
        }
    }

    /*calculates output of network*/
    public double[] output(double[] inputs) {
        double[] res = new double[0];
        for (int i = 0; i < layerSizes.length; i++) {
            if (i == 0) {
                res = layers[i].output(inputs);
            } else {
                res = layers[i].output(res);
            }
        }
        return res;
    }

}
