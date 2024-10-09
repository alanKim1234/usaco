import java.awt.*;
import java.io.*;
import java.util.*;

public class cow_gymnastics {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(new File("test.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] p = new int[k][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Point> con_pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j != i) {
                    con_pairs.add(new Point(p[0][i], p[0][j]));
                }
            }
        }


        for (int i = 1; i < k; i++) {
            for (Point pair : con_pairs) {
                if (Arrays.binarySearch(p[i], (int) pair.getX()) > 
                    Arrays.binarySearch(p[i], (int) pair.getY())) {

                    con_pairs.remove(pair);
                }
            }
        }
        pw.println(con_pairs.size());
        pw.close();
        br.close();
    }
}
