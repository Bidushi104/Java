import java.util.Arrays;

public class TravelingSalesman {
    private int n;
    private int[][] dist;
    private int[][] memo;
    private int VISITED_ALL;

    public TravelingSalesman(int[][] dist) {
        this.n = dist.length;
        this.dist = dist;
        this.VISITED_ALL = (1 << n) - 1;
        this.memo = new int[n][1 << n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
    }

    private int tsp(int pos, int visited) {
        if (visited == VISITED_ALL) {
            return dist[pos][0];
        }
        if (memo[pos][visited] != -1) {
            return memo[pos][visited];
        }
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((visited & (1 << city)) == 0) {
                int newAns = dist[pos][city] + tsp(city, visited | (1 << city));
                ans = Math.min(ans, newAns);
            }
        }
        memo[pos][visited] = ans;
        return ans;
    }

    public int solve() {
        return tsp(0, 1);
    }

    public static void main(String[] args) {
        int[][] dist = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        TravelingSalesman tsp = new TravelingSalesman(dist);
        int result = tsp.solve();
        System.out.println("Minimum tour cost: " + result);
    }
}
