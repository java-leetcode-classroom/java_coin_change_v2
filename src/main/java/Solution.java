import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Solution {
  static class CoinRecord {
    private final int start;
    private final int amount;

    public CoinRecord(int start, int amount) {
      this.start = start;
      this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof CoinRecord)) return false;
      CoinRecord that = (CoinRecord) o;
      return start == that.start && amount == that.amount;
    }

    @Override
    public int hashCode() {
      return Objects.hash(start, amount);
    }
  }
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
  public int changeDFS(int amount, int[] coins) {
    int cLen = coins.length;
    HashMap<CoinRecord, Integer> cache = new HashMap<>();
    return DFS(cache, coins, 0, 0, amount);
  }
  public int DFS(HashMap<CoinRecord, Integer> cache, int[] coins, int amount, int start, int target) {
    if (target == amount) {
      return 1;
    }
    if (amount > target) {
      return 0;
    }
    if (start >= coins.length) {
      return 0;
    }
    CoinRecord record = new CoinRecord(start, amount);
    if (cache.containsKey(record)) {
      return cache.get(record);
    }
    int previous = DFS(cache, coins, amount, start+1, target);
    int remain = DFS(cache, coins, amount+coins[start], start, target);
    cache.put(record, previous+remain);
    return previous+remain;
  }
}
