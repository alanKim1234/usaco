import java.io.*;
import java.util.*;

public class candy_cane_feast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("2.in"));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = br.readLine();
        int n = Integer.parseInt(st.nextToken()); //read in n
        int m = Integer.parseInt(st.nextToken()); //read in m
        
        st = new StringTokenizer(br.readLine());
        String s2 = br.readLine();
        long[] mList = convert(n, st);//Cow heights

        long[] taken_values = new long[m]; 

        st = new StringTokenizer(br.readLine());
        br.mark(s1.length() + s2.length());

        for (long cow : mList) {
            for (int i = 0; i < m; i++) {
                long current_candy = Long.parseLong(st.nextToken());
                if (cow > current_candy && current_candy > taken_values[i]) {
                    long inc = Math.min(cow, current_candy) - taken_values[i];

                    if (inc > 0) {
                        cow += inc;
                        taken_values[i] = inc;
                    }
                }
            }
            br.reset();
            System.out.println(cow);
        }
    }

    public static long[] returnCandyHeights(int h) {
        long[] arr = new long[h];

        for (int i = 0; i < h; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    public static long returnCowHeight(long cow_height, long[][] ccH) {
        long h = cow_height;

        for (long[] ccH1 : ccH) {
            for (int j = 0; j < ccH1.length; j++) {
                if (cow_height >= ccH1[j]) {
                    if (ccH1[j] != 0) {
                        ccH1[j] = 0;
                        ++h;
                    }
                } else {
                    break;
                }
            }
        }

        return h;
    }

    public static long[] convert(int length, StringTokenizer st) {
        long arr[] = new long[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        return arr;
       
    }
 }