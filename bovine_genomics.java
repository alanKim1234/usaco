import java.io.*;
import java.util.*;

public class bovine_genomics {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter(new File("cownomics.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] spotted = new String[n][m];
        String[][] plain = new String[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
               spotted[i][j] = s.charAt(j) + "";     
            }
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
               plain[i][j] =  s.charAt(j) + "";     
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            String[] spotN = new String [n];
            String[] plainN = new String [n];

            for (int j = 0; j < n; j++) {
                spotN[j] = spotted[j][i];
                plainN[j] = plain[j][i];
            }

            boolean disjoint = true;
            for (String spot : spotN) {
                if (!match(plainN, spot)) {
                    disjoint = false;
                    break;
                }
            }

            if (disjoint == true) {
                ++count;
            }
            

        }
        
        pw.println(count);
        pw.close();
        br.close();
    }

    public static boolean match(String[] a, String s) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(s)) {
                return false;
            }
        }

        return true;
    }
}
