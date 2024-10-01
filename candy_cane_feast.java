import java.io.*;
import java.util.*;

public class candy_cane_feast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //read in n  
        int m = Integer.parseInt(st.nextToken()); //read in m
        
        st = new StringTokenizer(br.readLine());
        long[] mList = convert(n, st);//Cow heights

        long[] taken_values = new long[m]; 

        String candy_cane_heights = br.readLine();
        String[] ccH = candy_cane_heights.split(" ");

        for (int j = 0; j < mList.length; j++) {
            for (int i = 0; i < m; i++) {
                long current_candy = Long.parseLong(ccH[i]);
                long inc = Math.min(mList[j], current_candy) - taken_values[i];

                if (inc > 0) {
                    mList[j] += inc;
                    taken_values[i] = inc;
                }
                
            }
        }

        for (int i = 0; i < mList.length; i++) {
            System.out.println(mList[i]);
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