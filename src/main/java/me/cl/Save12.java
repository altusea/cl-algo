package me.cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Save12 {

    static void dfs(int i, int u, int n, int[][] mat, int[] res) {
        res[0] = Math.max(u, res[0]);
        for (int j = 0; j <= n; j++) {
            if (mat[i][j] > 0) {
                dfs(j, u + mat[i][j], n, mat, res);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] t = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            int up = Integer.parseInt(info[0]);
            int dn = Integer.parseInt(info[1]);
            t[up][dn] = 1;
        }
        if (t[0][1] == 1) t[0][1] = 2;
        int[] res = new int[1];
        for (int i = 1; i <= n; i++) {
            if (t[0][i] > 0) {
                dfs(i, t[0][i], n, t, res);
            }
        }
        System.out.println(res[0]);
    }
}
