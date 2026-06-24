import java.util.Scanner;

public class Knapsack {

    public static int knapsack(int[] cost, int[] risk, int budget, int n) {

        int[][] dp = new int[n + 1][budget + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= budget; w++) {

                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }

                else if (cost[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            risk[i - 1] + dp[i - 1][w - cost[i - 1]],
                            dp[i - 1][w]
                    );
                }

                else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][budget];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== FINPULSE FRAUD ANALYTICS SYSTEM =====");

        System.out.print("Enter Number of Suspicious Transactions: ");
        int n = sc.nextInt();

        int[] cost = new int[n];
        int[] risk = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nTransaction " + (i + 1));

            System.out.print("Investigation Cost: ");
            cost[i] = sc.nextInt();

            System.out.print("Risk Score: ");
            risk[i] = sc.nextInt();
        }

        System.out.print("\nEnter Investigation Budget: ");
        int budget = sc.nextInt();

        int result = knapsack(cost, risk, budget, n);

        System.out.println("\nMaximum Fraud Risk Detected: " + result);

        sc.close();
    }
}