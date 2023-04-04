import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Save05 {

    static class BreakGlass {
        int pos;
        int cost;
        int hurt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        int n = Integer.parseInt(param[0]), v = Integer.parseInt(param[1]), initialPos = Integer.parseInt(param[2]);

        BreakGlass[] glasses = new BreakGlass[n];

        for (int l = 0; l < n; l++) {
            String[] info = br.readLine().split(" ");
            int pos = Integer.parseInt(info[0]), cost = Integer.parseInt(info[1]), hurt = Integer.parseInt(info[2]);
            BreakGlass glass = new BreakGlass();
            glass.pos = pos;
            glass.cost = cost;
            glass.hurt = hurt;
            glasses[l] = glass;
        }

        int[] global = {Integer.MAX_VALUE};

        boolean[] vis = new boolean[n];

        int costAcc = 0;

        for (int i = 0; i < n; i++) {
            int newCostAcc = costAcc;
            int t = Math.abs(initialPos - glasses[i].pos) / v; // 移动时间
            for (int g = 0; g < n; g++) {
                if (!vis[g]) {
                    newCostAcc += glasses[g].hurt * t;
                }
            }

            vis[i] = true;
            dfs(glasses, vis, glasses[i].pos, global, 1, newCostAcc + glasses[i].cost, v);
            vis[i] = false;
        }

        System.out.println(global[0]);
    }

    private static void dfs(BreakGlass[] glasses, boolean[] vis, int oldPos, int[] global, int fixedCnt, int costAcc, int v) {

        int n = glasses.length;

        if (fixedCnt == n) {
            global[0] = Math.min(global[0], costAcc);
            return;
        }

        if (costAcc > global[0]) return;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int newCostAcc = costAcc;
                int t = Math.abs(oldPos - glasses[i].pos) / v; // 移动时间
                for (int g = 0; g < n; g++) {
                    if (!vis[g]) {
                        newCostAcc += glasses[g].hurt * t;
                    }
                }

                vis[i] = true;
                dfs(glasses, vis, glasses[i].pos, global, fixedCnt + 1, newCostAcc + glasses[i].cost, v);
                vis[i] = false;
            }
        }
    }
}
