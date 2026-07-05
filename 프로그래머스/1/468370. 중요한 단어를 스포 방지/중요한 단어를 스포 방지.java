import java.util.*;

class Solution {

    static class Word {
        String text;
        int start;
        int end;

        Word(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
        }
    }

    public int solution(String message, int[][] spoiler_ranges) {

        int n = message.length();

        // 문자가 어떤 spoiler에 포함되는지
        int[] spoilerId = new int[n];
        Arrays.fill(spoilerId, -1);

        for (int i = 0; i < spoiler_ranges.length; i++) {
            for (int j = spoiler_ranges[i][0]; j <= spoiler_ranges[i][1]; j++) {
                spoilerId[j] = i;
            }
        }

        // 단어 파싱
        List<Word> words = new ArrayList<>();

        int idx = 0;
        while (idx < n) {

            if (message.charAt(idx) == ' ') {
                idx++;
                continue;
            }

            int s = idx;

            while (idx < n && message.charAt(idx) != ' ')
                idx++;

            int e = idx - 1;

            words.add(new Word(message.substring(s, idx), s, e));
        }

        int m = words.size();

        List<List<Integer>> spoilerWords = new ArrayList<>();
        for (int i = 0; i < spoiler_ranges.length; i++) {
            spoilerWords.add(new ArrayList<>());
        }

        int[] remain = new int[m];

        // 평문으로 등장한 단어
        Set<String> normalWords = new HashSet<>();

        for (int w = 0; w < m; w++) {

            Word word = words.get(w);

            Set<Integer> touched = new HashSet<>();

            for (int p = word.start; p <= word.end; p++) {
                if (spoilerId[p] != -1) {
                    touched.add(spoilerId[p]);
                }
            }

            if (touched.isEmpty()) {
                normalWords.add(word.text);
            } else {
                remain[w] = touched.size();

                for (int id : touched) {
                    spoilerWords.get(id).add(w);
                }
            }
        }

        int answer = 0;

        Set<String> revealed = new HashSet<>();

        for (int i = 0; i < spoiler_ranges.length; i++) {

            List<Integer> list = spoilerWords.get(i);

            // 이미 단어 순서대로 들어가 있으므로 정렬 불필요

            for (int w : list) {

                remain[w]--;

                if (remain[w] == 0) {

                    String text = words.get(w).text;

                    if (!normalWords.contains(text) && !revealed.contains(text)) {
                        answer++;
                    }

                    revealed.add(text);
                }
            }
        }

        return answer;
    }
}