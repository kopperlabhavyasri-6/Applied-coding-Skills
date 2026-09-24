class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }

        int[] trustScores = new int[n + 1];

        for (int[] relation : trust) {
            trustScores[relation[0]]--; // Person 'a' trusts someone
            trustScores[relation[1]]++; // Person 'b' is trusted by someone
        }

        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}