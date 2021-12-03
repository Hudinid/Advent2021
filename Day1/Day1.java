package Day1;
import java.util.*;
import java.io.*;
public class Day1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int ret = 0;
        
        int[] numbers = new int[2001];
        int sum = 0;
        for(int i = 1; i < 2001; i ++){
            int curr = Integer.parseInt(br.readLine());
            sum += curr;
            numbers[i] = sum;
        }

        int sum1 = 0;
        int sum2 = 0;
        
        for(int i = 1; i < numbers.length-3; i ++){ 
            sum1 = numbers[i+2] - numbers[i-1];
            sum2 = numbers[i+3] - numbers[i];
            if(sum2 > sum1) ret ++;
        }
        pw.println(ret);
        pw.close();
        br.close();
    }
}