class Solution {

    public int solution(int[] schedules, int[][] timelogs, int startday) {

        int answer = 0;
        int n = schedules.length;

        for (int i = 0; i < n; i++) {

            int limit = addTenMinutes(schedules[i]);
            boolean success = true;

            for (int j = 0; j < 7; j++) {

                // 현재 요일 계산
                int day = (startday + j - 1) % 7 + 1;

                // 토요일, 일요일은 제외
                if (day == 6 || day == 7)
                    continue;

                if (timelogs[i][j] > limit) {
                    success = false;
                    break;
                }
            }

            if (success)
                answer++;
        }

        return answer;
    }

    private int addTenMinutes(int time) {

        int hour = time / 100;
        int minute = time % 100;

        minute += 10;

        if (minute >= 60) {
            hour++;
            minute -= 60;
        }

        return hour * 100 + minute;
    }
}