import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1_000_000;
        
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for (int[] item : info) {
            int aTrace = item[0];
            int bTrace = item[1];
            
            int[] next = new int[m];
            Arrays.fill(next, INF);
            
            for (int b = 0; b < m; b++) {
                if (dp[b] == INF) continue;
                
                // 1. A도둑이 현재 물건을 훔치는 경우
                int nextA = dp[b] + aTrace;
                if (nextA < n) {
                    next[b] = Math.min(next[b], nextA);
                }
                
                // 2. B도둑이 현재 물건을 훔치는 경우
                int nextB = b + bTrace;
                if (nextB < m) {
                    next[nextB] = Math.min(next[nextB], dp[b]);
                }
            }
            
            dp = next;
        }
        
        int answer = INF;
        for (int b = 0; b < m; b++) {
            answer = Math.min(answer, dp[b]);
        }
        
        return answer == INF ? -1 : answer;
    }
}