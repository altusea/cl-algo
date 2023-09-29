package me.cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Save09 {

    static int CMN(int m, int n) {
        long x = 1;
        int i;
        for (i = 1; i <= m; i++) {
            x = x * (n - i + 1) / i;
        }
        return (int) x;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]), m = Integer.parseInt(param[1]);

        int[] arr = new int[m];
        int sum = 0;

        for (int l = 0; l < m; l++) {
            int x = Integer.parseInt(br.readLine());
            sum += x;
            arr[l] = x;
        }

        if (sum > n) {
            System.out.println("NoPlan");
        } else {
            int res = 1;

            for (int i = 0; i < m; i++) {
                res *= CMN(arr[i], n);
                res = res % 1024;
                n -= arr[i];
            }
            System.out.println(res);
        }
    }
}
