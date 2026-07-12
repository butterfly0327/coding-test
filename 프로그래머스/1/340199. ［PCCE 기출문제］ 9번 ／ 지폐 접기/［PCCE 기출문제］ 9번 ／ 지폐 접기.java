class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int walletSmall = Math.min(wallet[0], wallet[1]);
        int walletLarge = Math.max(wallet[0], wallet[1]);

        while (true) {
            int billSmall = Math.min(bill[0], bill[1]);
            int billLarge = Math.max(bill[0], bill[1]);

            // 그대로 넣거나 90도 돌려서 넣을 수 있는 경우
            if (billSmall <= walletSmall && billLarge <= walletLarge) {
                break;
            }

            // 항상 지폐의 긴 쪽을 반으로 접는다.
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }

            answer++;
        }

        return answer;
    }
}