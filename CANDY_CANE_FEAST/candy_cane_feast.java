import java.io.*;
import java.util.*;

public class candy_cane_feast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //read in n  
        int m = Integer.parseInt(st.nextToken()); //read in m
        
        st = new StringTokenizer(br.readLine());
        long[] mList = new long[n];//Cow heights

        for (int i = 0; i < n; i++) {
            mList[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
       
        while(m-- > 0) {
            long current_candy = Long.parseLong(st.nextToken());
            long taken = 0;
            for (int i = 0; i < mList.length && taken < current_candy; i++) {
                long inc = Math.min(mList[i], current_candy) - taken;
                if (inc > 0) {
                    mList[i] += inc;
                    taken += inc;
                }
            }
        }

        for (int i = 0; i < n; i++) System.out.println(mList[i]);
    }
}