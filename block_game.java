import java.io.*;
import java.util.*;

public class block_game {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new File("blocks.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        int[] alphabet = new int[26];

        for (int i = 0; i < n; i++) {
            int[] betainc = new int[26];
            int[] alphainc = new int[26];
            boolean[] flag = new boolean[26];
            String s = br.readLine();
            String[] words = s.split(" ");

            for (String word : words) {
                for (int k = 0; k < word.length(); k++) {
                    int index = word.charAt(k) - 97;
                    if (Character.isLetter(word.charAt(k)) && flag[index] == false) {
                        ++alphainc[index];
                    } else {
                        ++betainc[index];
                    }
                }
                for (int k = 0; k < word.length(); k++) {
                    flag[word.charAt(k) - 97] = true;
                }
            }

            for (int a = 0; a < 26; a++) {
                alphabet[a] += Math.max(alphainc[a], betainc[a]); 
            }
        }


        for (int i : alphabet) {
            pw.println(i);
        }

        pw.close();
        br.close();
    }   
}
