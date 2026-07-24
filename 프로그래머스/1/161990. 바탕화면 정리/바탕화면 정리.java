class Solution {
    public int[] solution(String[] wallpaper) {
        int top = wallpaper.length;
        int left = wallpaper[0].length();
        int bottom = 0;
        int right = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    top = Math.min(top, i);
                    left = Math.min(left, j);

                    bottom = Math.max(bottom, i + 1);
                    right = Math.max(right, j + 1);
                }
            }
        }

        return new int[]{top, left, bottom, right};
    }
}