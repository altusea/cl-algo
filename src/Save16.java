import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Save16 {

    static void dfs(int i, int cost, int acc, int[][] mat, int[] res, boolean[] visited, int count) {
        if (res[0] != Integer.MIN_VALUE && res[0] <= cost + acc) return;
        int n = mat.length - 1;
        if (count == n) {
            res[0] = Math.min(res[0], cost + acc);
        }
        for (int j = 1; j <= n; j++) {
            if (!visited[j]) {
                visited[j] = true;
                dfs(j, mat[i][j], acc + cost, mat, res, visited, count + 1);
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int m = N * (N - 1) / 2;
        int[][] mat = new int[N + 1][N + 1];

        for (int l = 0; l < m; l++) {
            String[] info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            int dis = Integer.parseInt(info[2]);

            mat[start][end] = dis;
            mat[end][start] = dis;
        }

        int[] res = {Integer.MAX_VALUE};
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    dfs(j, mat[i][j], 0, mat, res, visited, 2);
                    visited[j] = false;
                }
            }
            visited[i] = false;
        }
    }
}
