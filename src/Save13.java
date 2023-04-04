import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Save13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] heightsStr = br.readLine().split(" ");
            List<Integer> heightsInt = new ArrayList<>();
            for (String s : heightsStr) {
                heightsInt.add(Integer.parseInt(s));
            }
            heightsInt.sort(Comparator.comparingInt(o -> o));
            System.out.println(heightsInt.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
