package me.cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Save01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> data = new ArrayList<>();

        for (int l = 0; l < N; l++) {
            String[] info = br.readLine().split(" ");
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(info[0]);
            arr[1] = Integer.parseInt(info[1]);
            data.add(arr);
        }

        List<int[]> front = data.stream()
                .filter(item -> item[0] <= item[1])
                .sorted(Comparator.comparingInt(o -> o[0]))
                .toList();
        List<int[]> rear = data.stream()
                .filter(item -> item[0] > item[1])
                .sorted((o1, o2) -> o2[1] - o1[1])
                .toList();

        int a = 0, total = 0;
        for (int[] item : front) {
            a += item[0];
            total = Math.max(a, total) + item[1];
        }
        for (int[] item : rear) {
            a += item[0];
            total = Math.max(a, total) + item[1];
        }

        System.out.println(total);
    }
}
