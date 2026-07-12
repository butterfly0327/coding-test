class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        int targetRow = (num - 1) / w;
        int targetCol = getColumn(num, w);

        for (int box = num; box <= n; box++) {
            int row = (box - 1) / w;
            int col = getColumn(box, w);

            // 목표 상자와 같은 열에 있는 상자만 꺼내야 한다.
            if (row >= targetRow && col == targetCol) {
                answer++;
            }
        }

        return answer;
    }

    private int getColumn(int box, int w) {
        int row = (box - 1) / w;
        int index = (box - 1) % w;

        // 짝수 층: 왼쪽 → 오른쪽
        if (row % 2 == 0) {
            return index;
        }

        // 홀수 층: 오른쪽 → 왼쪽
        return w - 1 - index;
    }
}