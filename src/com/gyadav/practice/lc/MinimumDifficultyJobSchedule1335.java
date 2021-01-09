package com.gyadav.practice.lc;

public class MinimumDifficultyJobSchedule1335 {
    public static void main(String[] a) {
        MinimumDifficultyJobSchedule1335 minimumDifficultyJobSchedule1335 = new MinimumDifficultyJobSchedule1335();
        System.out.println(minimumDifficultyJobSchedule1335.minDifficulty(new int[]{11,111,22,222,33,333,44,444}, 6));
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        return bruteForceWithoutMemo(jobDifficulty,0, d, jobDifficulty.length);
    }

    private int bruteForceWithoutMemo(int[] jd, int pos, int d, int len)
    {
        if(d == 0 && pos == len) return 0;
        if(d == 0 || pos == len) return Integer.MAX_VALUE;

        int currMax = jd[pos];
        int val = Integer.MAX_VALUE;

        for(int i = pos; i < len; i++)
        {
            currMax = Math.max(jd[i], currMax);
            int temp = bruteForceWithoutMemo(jd, i+1, d-1, len);
            if(temp != Integer.MAX_VALUE)
            {
                val = Math.min(val, currMax+temp);
            }
        }

        return val;
    }

    private int minDifficultyRecursive(int[] jobDifficulty, int d, int index) {
        if (jobDifficulty.length == index || d == 0)
            return 0;

        int c1 = Math.max(jobDifficulty[index], minDifficultyRecursive(jobDifficulty, d, index + 1));
        int c2 = minDifficultyRecursive(jobDifficulty, d - 1, index);
        return Math.min(c1, c2);
    }
}
