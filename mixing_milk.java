import java.io.*;
import java.util.*;

public class mixing_milk {
    public static int N = 3; //bucket count
    public static int C = 100; //the number of pours;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mixmilk.out"));

        int[] capacity = new int[N]; //Capacity of each Bucket
        int[] intial = new int[N]; //Intial starting value of each bucket

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            capacity[i] = Integer.parseInt(st.nextToken());
            intial[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= C; i++) {
            int b = (i - 1) % N;
            int n = b + 1;
            if (b == 2) n = 0;

            int temp = intial[n];
            intial[n] += (capacity[n] - intial[n] > intial[b]) ? intial[b] : capacity[n] - intial[n];
            intial[b] -= (capacity[n] - temp > intial[b]) ? intial[b] : capacity[n] - temp;
        }

        for (int i : intial) {
            pw.println(i);
        }
        pw.close();
        br.close();
    }
}
