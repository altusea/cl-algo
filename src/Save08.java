import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class Save08 {

    static class Team {

        int score = 0;
        int balls = 0, op = 0;
        int order;

        HashSet<Team> win = new HashSet<>();

        public Team(int order) {
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = n * (n - 1) / 2;

        HashMap<String, Team> map = new HashMap<>();

        String[] teams = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            map.put(teams[i], new Team(i));
        }
        for (int i = 0; i < m; i++) {
            String[] game = br.readLine().split(" ");
            String teamA = game[0], teamB = game[3];
            int ballsA = Integer.parseInt(game[1]), ballsB = Integer.parseInt(game[2]);

            Team aTeam = map.get(teamA), bTeam = map.get(teamB);
            aTeam.balls += ballsA;
            aTeam.op += ballsA - ballsB;
            bTeam.balls += ballsB;
            bTeam.op += ballsB - ballsA;

            if (ballsA > ballsB) {
                aTeam.score += 3;
                aTeam.win.add(bTeam);
            } else if (ballsA == ballsB) {
                aTeam.score += 1;
                bTeam.score += 1;
            } else {
                bTeam.score += 3;
                bTeam.win.add(aTeam);
            }
        }

        System.out.println(map.entrySet().stream().sorted((o1, o2) -> {
            Team a = o1.getValue(), b = o2.getValue();

            if (a.score != b.score) return b.score - a.score;
            if (a.op != b.op) return b.op - a.op;
            if (a.win.contains(b)) {
                return -1;
            } else if (b.win.contains(a)) {
                return 1;
            } else {
                if (a.balls != b.balls) return b.balls - a.balls;
                return a.order - b.order;
            }
        }).map(Map.Entry::getKey).collect(Collectors.joining("\n")));
    }
}
