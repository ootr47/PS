import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int targetSum = wanho[0] + wanho[1];

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        int maxB = 0;
        boolean wanhoValid = true;
        List<Integer> valid = new ArrayList<>();

        for (int[] score : scores) {
            int a = score[0];
            int b = score[1];

            if (b < maxB) {
                if (score == wanho) wanhoValid = false;
            } else {
                maxB = b;
                valid.add(a + b);
            }
        }
        
        if (!wanhoValid) return -1;

        valid.sort(Collections.reverseOrder());
        for (int i = 0; i < valid.size(); i++) {
            if (valid.get(i) == targetSum) {
                return i + 1;
            }
        }

        return -1;
    }
}
