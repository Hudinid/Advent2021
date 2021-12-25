package Day2;
import java.io.*;
import java.util.*;
public class Day2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int d = 0;
        int h = 0;
        int aim = 0;
        for(int i = 0; i < 1000;i  ++) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            // System.out.println(d);
            if(tokens[0].equals("up")){
                aim -= Integer.parseInt(tokens[1]);
            }
            if(tokens[0].equals("down")) {
                aim += Integer.parseInt(tokens[1]);
            }
            if(tokens[0].equals("forward")) {
                h += Integer.parseInt(tokens[1]);
                d += Integer.parseInt(tokens[1]) * aim;
            }
        }

        pw.println(d*h);
        pw.close();
        br.close();
    }
}
