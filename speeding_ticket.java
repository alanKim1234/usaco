import java.io.*;
import java.util.*;

public class speeding_ticket {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(new File("speeding.out"));
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[] r_segments = new int[100];
        int[] segments = new int[100];

        int start = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            
            for (int j = start; j < start + length; j++) {
                r_segments[j] = speed;
            }

            start += length;
        }

        start = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for (int j = start; j < length + start; j++) {
                segments[j] = speed;
            }

            start += length;
        }

        int max_diff = 0;
        for (int i = 0; i < 100; i++) {
            if (segments[i] > r_segments[i]) {
                max_diff = Math.max(max_diff, segments[i] - r_segments[i]);
            }
        }

        pw.println(max_diff);
        pw.close();
        br.close();

    }
}
