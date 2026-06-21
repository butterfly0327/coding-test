class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        // remove[i] = i시가 되었을 때 반납해야 하는 서버 수
        int[] remove = new int[25];

        // 현재 운영 중인 증설 서버 수
        int currentServer = 0;

        for (int i = 0; i < 24; i++) {
            // i시에 반납되는 서버 제거
            currentServer -= remove[i];

            // i시에 필요한 증설 서버 수
            int needServer = players[i] / m;

            // 현재 서버 수가 부족하면 추가 증설
            if (currentServer < needServer) {
                int addServer = needServer - currentServer;

                answer += addServer;
                currentServer += addServer;

                // i시에 증설한 서버는 i + k시에 반납
                if (i + k <= 24) {
                    remove[i + k] += addServer;
                }
            }
        }

        return answer;
    }
}