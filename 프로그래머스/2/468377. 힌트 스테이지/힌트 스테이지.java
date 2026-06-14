import java.util.*;

class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;

        int bundleCount = n - 1;
        int maxMask = 1 << bundleCount;

        long answer = Long.MAX_VALUE;

        for (int mask = 0; mask < maxMask; mask++) {
            int[] hintCount = new int[n];
            long total = 0;

            // 1. 현재 mask에 해당하는 번들들을 구매
            for (int i = 0; i < bundleCount; i++) {
                if ((mask & (1 << i)) == 0) {
                    continue;
                }

                // 번들 가격 추가
                total += hint[i][0];

                // 번들 안의 힌트권 추가
                for (int j = 1; j < hint[i].length; j++) {
                    int stageNumber = hint[i][j]; // 1-based
                    hintCount[stageNumber - 1]++;
                }
            }

            // 2. 각 스테이지 해결 비용 계산
            for (int i = 0; i < n; i++) {
                int useCount = Math.min(hintCount[i], n - 1);
                total += cost[i][useCount];
            }

            answer = Math.min(answer, total);
        }

        return (int) answer;
    }
}