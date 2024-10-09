import java.io.*;
import java.util.*;

public class why_did_the_cow_cross_the_road_II {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter pw = new PrintWriter(new File("circlecross.out"));

        String s = br.readLine();
        HashMap<Character, int[]> positions = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!positions.containsKey(c)) {
                positions.put(c, new int[] {i, -1});
            } else {
                positions.get(c)[1] = i;
            }
        }

        int count = 0;
        for (char c1 = 'A'; c1 <= 'Z'; c1++) {
            for (char c2 = (char) (c1 + 1); c2 <= 'Z'; c2++) {
                int s1 = positions.get(c1)[0];
                int e1 = positions.get(c1)[1];
                int s2 = positions.get(c2)[0];
                int e2 = positions.get(c2)[1];

                if ((s1 < s2 && e1 < e2 && s2 < e1) || (s2 < s1  && e2 < e1 && s1 < e2) ) {
                    ++count;
                }
            }
        }

        pw.println(count);
        pw.close();
        br.close();
    }

}
