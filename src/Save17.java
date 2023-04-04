import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Save17 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int res = -1;
        if (n % 2 == 1 || n < 6) {
            // do nothing
        } else if (n % 8 == 0) {
            res = n / 8;
        } else {
            int num8 = n / 8, num6;
            while (num8 >= 0) {
                int after8 = n - num8 * 8;
                if (after8 % 6 == 0) {
                    num6 = after8 / 6;
                    res = num6 + num8;
                    break;
                }
                num8--;
            }
        }

        System.out.println(res);
    }
}
