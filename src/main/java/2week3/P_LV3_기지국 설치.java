import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = 2 * w + 1;
        int position = 1;

        for (int s : stations) {
            int left = s - w;
            int right = s + w;

            if (position < left) {
                int gap = left - position;
                answer += Math.ceil((double) gap / cover);
            }
            position = right + 1;
        }

        if (position <= n) {
            int gap = n - position + 1;
            answer += Math.ceil((double) gap / cover);
        }

        return answer;
    }
}
