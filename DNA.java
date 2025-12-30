package KnapSack;
import java.util.Random;

public class DNA {
    int[] genes;
    long fitness;
    static Random rand = new Random();

    public DNA(int geneLength) {
        genes = new int[geneLength];
        for(int i=0; i<geneLength; i++) {
            genes[i] = rand.nextInt(2);
        }
    }

    public DNA(DNA other) {
        this.genes = other.genes.clone();
        this.fitness = other.fitness;
    }

    public void mutate(double mutationRate) {
        for(int i=0; i<genes.length; i++) {
            if(rand.nextDouble() < mutationRate)
                genes[i] = (genes[i] == 0) ? 1 : 0;
        }
    }
}
