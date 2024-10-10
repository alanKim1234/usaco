import java.awt.*;
import java.io.*;
import java.util.*;

public class cow_gymnastics {

    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("gymnastics.in")); 
            PrintWriter pw = new PrintWriter(new File("gymnastics.out"))) {
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
                for (int j = i; j < n; j++) {
                    if (j != i && i < j) {
                        con_pairs.add(new Point(p[0][i], p[0][j]));
                    }
                }
            }
            
            for (int i = 1; i < k; i++) {
                Iterator<Point> it = con_pairs.iterator();
                while (it.hasNext()) {
                    Point pair = it.next();
                    // 4 1 3 2
                    // (1, 2)
                    //
                    if (returnIndex(p[i], (int) pair.getX()) >
                            returnIndex(p[i], (int) pair.getY())) {
                        
                        it.remove();
                    }
                }
            }
            
            pw.println(con_pairs.size());
        }
    }


    public static int returnIndex(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) return i;
        }

        return -1;
    }
}
