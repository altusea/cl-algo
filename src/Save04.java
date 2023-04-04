import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Save04 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] viruses = new String[n];
            for (int i = 0; i < n; i++) {
                viruses[i] = br.readLine();
            }

            String program = br.readLine();

            StringBuilder sb = new StringBuilder();
            int id = 0;
            while (id < program.length()) {
                if (program.charAt(id) == '[') {
                    id++;
                    int acc = 0;
                    char ch = program.charAt(id);
                    while (Character.isDigit(ch)) {
                        int num = program.charAt(id) - '0';
                        acc = acc * 10 + num;
                        id++;
                        ch = program.charAt(id);
                    }

                    char repeat = program.charAt(id);
                    sb.append(String.valueOf(repeat).repeat(Math.max(0, acc)));
                    id += 2;
                } else {
                    sb.append(program.charAt(id));
                    id++;
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                StringBuilder rev = new StringBuilder(viruses[i]).reverse();
                if (sb.indexOf(viruses[i]) >= 0 || sb.indexOf(rev.toString()) >= 0) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
