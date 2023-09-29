package me.cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Save06 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < a; i++) {
            String[] names = br.readLine().split(" ");
            for (String name : names) {
                map.put(name, map.getOrDefault(name, 0) + 1);
            }
        }

        int times = 0;
        String name = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > times) {
                times = entry.getValue();
                name = entry.getKey();
            }
        }
        System.out.println(name);
    }
}
