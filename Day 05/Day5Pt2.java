package Day5;

import java.io.*;
import java.util.*;
public class Day5Pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int[][] map = new int[1000][1000];
        
        for(int i = 0; i < 500; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] tokens = st.nextToken().split(",");
            st.nextToken();
            String[] tokens2 = st.nextToken().split(",");

            boolean triggered = false;

            int x1 = Integer.parseInt(tokens[0]);
            int y1 = Integer.parseInt(tokens[1]);
            int x2 = Integer.parseInt(tokens2[0]);
            int y2 = Integer.parseInt(tokens2[1]);

            if(x1 == x2) {
                int start = Math.min(y1, y2);
                int end = Math.max(y1, y2);
                for(int j = start; j <= end; j ++) {
                    map[x1][j] = map[x1][j] + 1;
                }
                continue;
            }

            if(y1 == y2) {
                int start = Math.min(x1, x2);
                int end = Math.max(x1, x2);
                for(int j = start; j <= end; j ++) {
                    map[j][y1] = map[j][y1] + 1;
                }
                continue;
            }

            if((y2-y1) / (x2-x1) == -1) { // negative slope
                int tempCount = Math.max(y1, y2);
                for(int j = Math.min(x1, x2); j <= Math.max(x1, x2); j ++) {
                    map[j][tempCount] = map[j][tempCount] + 1;
                    tempCount --; 
                }
            }
            else if((y2-y1) / (x2-x1) == 1) { //positive slope 
                int tempCount = Math.min(y1, y2);
                for(int j = Math.min(x1,x2); j <= Math.max(x1,x2); j++){
                    map[j][tempCount] = map[j][tempCount] + 1;
                    tempCount++;
                }
            }
        }
        
        int ret = 0;
        for(int i = 0; i < 1000; i ++){
            for(int j = 0; j < 1000; j ++){
                if(map[i][j] > 1) {
                    ret ++;
                }
            }
        }
        System.out.println(ret);
    }
}
