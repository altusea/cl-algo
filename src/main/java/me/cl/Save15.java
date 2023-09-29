package me.cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <a href="https://leetcode.cn/problems/wildcard-matching/solutions/316381/zi-fu-chuan-dong-tai-gui-hua-bi-xu-miao-dong-by-sw/">题解</a>
 */
public class Save15 {

    static boolean isMatch(String p, String s) {
        int lenP = p.length(), lenS = s.length();
        boolean[][] dp = new boolean[lenP + 1][lenS + 1];
        dp[0][0] = true;
        for (int i = 1; i <= lenP; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[i][0] = true;
        }

        for (int i = 1; i <= lenP; i++) {
            for (int j = 1; j <= lenS; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }
        return dp[lenP][lenS];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String p = br.readLine().toLowerCase();
        String s = br.readLine().toLowerCase();
        System.out.println(isMatch(p, s));
    }
}
