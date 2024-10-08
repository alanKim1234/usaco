import java.io.*;
import java.util.*;

public class cowntact_tracing_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());                             

        int n = Integer.parseInt(st.nextToken());
        String c = br.readLine();

        if (c.indexOf("1") == -1) {
            System.out.println("0");
            System.exit(0);
        }

        ArrayList<Integer> in = new ArrayList<Integer>();
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (c.charAt(i) == '0' && count > 0) {
                in.add(count);
                count = 0;
            } else if (c.charAt(i) == '1') {
                count++;
            }
        }

        if (count > 0) {
            in.add(count);
        }


        boolean left_zero = c.charAt(0) == '0';
        boolean right_zero = c.charAt(n - 1) == '0';

        int max_days = Math.min(in.get(0), in.get(in.size() - 1)) - 1;  
       
        if (left_zero) {
            max_days = Math.min(max_days, (in.get(0) - 1)/2);
        } 
        if (right_zero) {
            max_days = Math.min(max_days, (in.get(in.size() - 1) - 1 )/2);
        }
        

        for (int i = 1; i < in.size() - 1; i++) {
            max_days = Math.min(max_days, (in.get(i) - 1)/2);
        }

        int day_count = 0; 
        for (int i = 0; i < in.size(); i++) {
            day_count += (in.get(i) / (2 * max_days + 1));
            if (in.get(i) % (2 * max_days + 1) != 0)  {
                day_count += 1;
            }
        }

        System.out.println(day_count);
    
    }
    

}
