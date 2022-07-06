import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Solution {

  public int change(int amount, int[] coins) {
    int[] dp = new int[amount+1];
    dp[0] = 1;
    int cLen = coins.length;
    for (int start = cLen-1; start >= 0; start--) {
      int[] nextDP = new int[amount+1];
      nextDP[0] = 1;
      for (int m = 1; m <= amount; m++) {
        nextDP[m] = dp[m];
        if (m - coins[start] >= 0) {
          nextDP[m] += nextDP[m - coins[start]];
        }
      }
      dp = Arrays.copyOf(nextDP, amount+1);
    }
    return dp[amount];
  }
  public int changeV2(int amount, int[] coins) {
    int cLen = coins.length;
    int[][] dp = new int[amount+1][cLen+1];
    for (int start = 0; start <= cLen; start++) {
      dp[0][start] = 1;
    }
    for (int m = 1; m <= amount; m++) {
      for (int start = cLen - 1; start >= 0; start--) {
        dp[m][start] = dp[m][start+1];
        if (m-coins[start] >= 0) {
          dp[m][start] += dp[m-coins[start]][start];
        }
      }
    }
    return dp[amount][0];
  }
}
