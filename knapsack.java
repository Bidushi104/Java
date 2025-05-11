public class Knapsack {
    public static int knapsack(int W, int[] weights, int[] values, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (weights[n - 1] > W) {
            return knapsack(W, weights, values, n - 1);
        } else {
            return Math.max(values[n - 1] + knapsack(W - weights[n - 1], weights, values, n - 1),
                            knapsack(W, weights, values, n - 1));
        }
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] values = {60, 100, 120};
        int W = 5;
        int n = values.length;
        int result = knapsack(W, weights, values, n);
        System.out.println("Maximum value in Knapsack = " + result);
    }
}
