class Solution {
    public int solution(int[][] signals) {
        long limit = 1;

        for (int[] signal : signals) {
            int period = signal[0] + signal[1] + signal[2];
            limit = lcm(limit, period);
        }

        for (long time = 1; time <= limit; time++) {
            boolean allYellow = true;

            for (int[] signal : signals) {
                int g = signal[0];
                int y = signal[1];
                int r = signal[2];

                int period = g + y + r;
                long pos = (time - 1) % period;

                if (!(g <= pos && pos < g + y)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return (int) time;
            }
        }

        return -1;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}