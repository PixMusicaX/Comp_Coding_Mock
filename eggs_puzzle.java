import java.util.Scanner;

public class EggDrop {

    public static int minimumTrials(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];

        for (int i = 1; i <= eggs; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        for (int j = 1; j <= floors; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    int maxTrials = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
                    dp[i][j] = Math.min(dp[i][j], maxTrials);
                }
            }
        }

        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt();
        for (int t = 0; t < numTestCases; t++) {
            int eggs = scanner.nextInt();
            int floors = scanner.nextInt();
            int minTrials = minimumTrials(eggs, floors);
            System.out.println(minTrials);
        }

        scanner.close();
    }
}
