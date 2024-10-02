import java.io.*;
import java.util.*;

public class cowntact_tracing_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String c = br.readLine();

        ArrayList<Integer> in = new ArrayList<Integer>();
        
        int count = 0;
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == '0' && count > 0) {
                in.add(count);
            } else if (c.charAt(i) == '1') {
                count++;
            }
        }

        if (count > 0) {
            in.add(count);
        }

        

        
    }
    



}
