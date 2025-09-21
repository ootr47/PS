class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];

            if (n == 0L) {
                answer[i] = 0;
                continue;
            }

            String bin = Long.toBinaryString(n);

            int size = 1;
            while (size < bin.length()) size = size * 2 + 1;
            String padded = String.format("%" + size + "s", bin).replace(' ', '0');

            answer[i] = valid(padded.toCharArray(), 0, size - 1, false) ? 1 : 0;
        }
        return answer;
    }

    private boolean valid(char[] a, int l, int r, boolean parentZero) {
        if (l > r) return true;
        int mid = (l + r) / 2;
        char root = a[mid];

        if (parentZero && root == '1') return false;

        boolean nextParentZero = (root == '0');
        return valid(a, l, mid - 1, nextParentZero)
            && valid(a, mid + 1, r, nextParentZero);
    }
}
