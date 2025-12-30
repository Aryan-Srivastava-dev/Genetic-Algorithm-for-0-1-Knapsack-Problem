package KnapSack;
import java.util.*;

public class Population {
    int geneLength;
    double mutationRate;
    int[] weights;
    int[] values;
    int W;
    List<DNA> members;
    static Random rand = new Random();

    public Population(int size, int geneLength, double mutationRate, int[] weights, int[] values, int W) {
        this.geneLength = geneLength;
        this.mutationRate = mutationRate;
        this.weights = weights;
        this.values = values;
        this.W = W;
        members = new ArrayList<>();
        for(int i=0; i<size; i++) {
            members.add(new DNA(geneLength));
        }
    }

    public void evaluate() {
        for(DNA member: members) {
            member.fitness = Fitness.evaluate(member, weights, values, W);
        }
    }

    public DNA selectParent() {
        DNA best = null;
        for(int i=0; i<3; i++) {
            DNA candidate = members.get(rand.nextInt(members.size()));
            if(best == null || candidate.fitness > best.fitness)
                best = candidate;
        }

        return best;
    }

    public DNA crossover(DNA p1, DNA p2) {
        int split = rand.nextInt(geneLength);
        DNA child = new DNA(geneLength);
        for(int i=0; i<geneLength; i++) {
            child.genes[i] = (i < split) ? p1.genes[i] : p2.genes[i];
        }

        return child;
    }

    public DNA getBest() {
        DNA best = members.getFirst();
        for(DNA member: members) {
            if(member.fitness > best.fitness)
                best = member;
        }

        return best;
    }

    public long totalWeight() {
        DNA best = getBest();
        long totalWeight = 0;
        for(int i=0; i<geneLength; i++) {
            if(best.genes[i] == 1)
                totalWeight += weights[i];
        }

        return totalWeight;
    }

    public void evolve() {
        evaluate();
        List<DNA> nextGen = new ArrayList<>();

        nextGen.add(new DNA(getBest()));

        while(nextGen.size() < members.size()) {
            DNA p1 = selectParent();
            DNA p2 = selectParent();
            DNA child = crossover(p1, p2);
            child.mutate(mutationRate);
            nextGen.add(child);
        }

        members = nextGen;
    }
}
