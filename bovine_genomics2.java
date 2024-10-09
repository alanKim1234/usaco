import java.io.*;
import java.util.*;

public class bovine_genomics2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter(new File("cownomics.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] spotted = new String[n];
        String[] plain = new String[n];

        for (int i = 0; i < n; i++) {
            spotted[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            plain[i] = br.readLine();
        }

        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    Set<String>spotted_genomes = new HashSet<>();
                    Set<String>plain_genomes = new HashSet<>();

                    for (int w = 0; w < n; w++) {
                        String s = spotted[w];
                        String p = plain[w];
                        spotted_genomes.add(s.charAt(i) + "" + s.charAt(j) + "" + s.charAt(k));
                        plain_genomes.add(p.charAt(i) + "" +p.charAt(j) + "" + p.charAt(k));
                    }

                    boolean disjoint = true;
                    for (String spot : spotted_genomes) {
                        if (plain_genomes.contains(spot)) {
                            disjoint = false;
                            break;
                        }
                    }

                    if (disjoint == true) {
                        ++counter;
                    }
                }
            }
        }

        pw.println(counter);
        pw.close();
        br.close();
    }
}
