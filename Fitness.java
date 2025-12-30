package KnapSack;

public class Fitness {
    static public long evaluate(DNA ind, int[] weights, int[] values, int W) {
        long fitness = 0;
        long totalWeight = 0;
        for(int i=0; i<ind.genes.length; i++) {
            if(ind.genes[i] == 1) {
                fitness += values[i];
                totalWeight += weights[i];
            }
        }

        if(totalWeight > W)
            return fitness - 10 * (totalWeight - W);
        return fitness;
    }
}
