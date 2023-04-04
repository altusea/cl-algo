import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Save14 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean flag = false;
        String[] numbers = br.readLine().split(" ");
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(numbers[i])) {
                flag = true;
                break;
            }
            set.add(numbers[i]);
        }

        if (flag) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
