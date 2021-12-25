package Day8;
import java.util.*;
import java.io.*;

public class Day8pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        

        
        //2, 4, 3, 7
        int ret = 0;
        for(int i = 0; i < 200; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] signalPatterns = new String[10];
            ArrayList<String> words = new ArrayList<String>();
            int count = 0;
            while(st.hasMoreTokens()) {
                if(count < 10){
                    signalPatterns[count] = st.nextToken();
                    count ++;
                }
                else {
                    String line = st.nextToken();
                    if(line != "|"){
                        if(line.length() == 2 || line.length() == 4 || line.length() == 3 || line.length() == 7){
                            ret ++;
                        }
                    }
                }
            }
        }

        pw.println(ret);
        pw.close();
    }
}
