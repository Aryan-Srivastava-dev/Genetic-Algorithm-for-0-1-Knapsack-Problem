# Genetic Algorithm for 0/1 Knapsack Problem

This project implements a **Genetic Algorithm (GA)** to solve the **0/1 Knapsack Problem**, maximizing total value while keeping total weight under a given capacity.

---

## How It Works

1. **Initialize** a population of random candidate solutions (DNA).  
2. **Evaluate** fitness using values and weights, penalizing overweight solutions.  
3. **Evolve** over generations:
   - Tournament **selection** of parents  
   - **Crossover** to produce offspring  
   - **Mutation** to explore new solutions  
   - **Elitism**: preserve the best solution  
4. **Return** the best solution found.

---

## Code Structure

- `DNA.java` → candidate solution representation  
- `Fitness.java` → fitness evaluation with penalty  
- `Population.java` → GA logic: selection, crossover, mutation, evolution  
- `Main.java` → runs the GA and prints results

---

## Result

Generation: 1000
Mutation Rate: 0.5%
Current Max value in Knapsack: 54413420
Gene sequence for weights: [0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1]
Total Weight of the best solution: 54413361
