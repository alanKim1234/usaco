
import java.io.*;
import java.util.*;

public class shell_game {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(new FileWriter("shell.out"));
        /*
            1. n is the number of times that the swap is occured
            2. the first two numbers in each line is the two shells that are swapped 
                EX: if your given 1 3
                    that means the shell order would not be 3 2 1
            3. the third number in a line is the number shell that is guessed
                EX: if g is 3 that means you guessed shell NUMBER 3, in this case 
                    with the  numbers above would be 1. So you add one count to 1.
        
        */ 

        int n = Integer.parseInt(st.nextToken());

        //the 3 shells
        int[] shells = new int[3];

        for (int i = 0; i < 3; i++) {shells[i] = i;}

        //guessed count for each shell
        int[] counter = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int g = Integer.parseInt(st.nextToken()) - 1;

            int temp = shells[a];
            shells[a] = shells[b];
            shells[b] = temp;

            ++counter[shells[g]];
        }   

        pw.println(Math.max(counter[0], Math.max(counter[1], counter[2])));
        pw.close();
        br.close();
    }
}
