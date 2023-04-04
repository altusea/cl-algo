import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Save10 {

    static class Employee {
        String name;
        int score;

        public Employee(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]), m = Integer.parseInt(param[1]);

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            String name = info[1];
            int score = Integer.parseInt(info[2]);
            map.put(name, map.getOrDefault(name, 0) + score);
        }

        PriorityQueue<Employee> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.score - o1.score);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.add(new Employee(entry.getKey(), entry.getValue()));
        }
        List<String> res = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            res.add(priorityQueue.poll().name);
        }
        System.out.println(String.join(" ", res));
    }
}
