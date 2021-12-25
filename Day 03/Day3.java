package Day3;
import java.util.*;
import java.io.*;
public class Day3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        
        String[] numbers = new String[1000];
        for(int i = 0; i < 1000; i ++){ 
            numbers[i] = br.readLine();
        }
        // Character.getNumericValue()
        int[] count0 = new int[12];
        int[] count1 = new int[12];
        
        
        for(int i = 0; i < 1000; i ++){
            for(int j = 0; j < 12; j ++) {
                if(Integer.parseInt(String.valueOf(numbers[i].charAt(j))) == 0){
                    count0[j] ++;
                }
                else {
                    count1[j] ++;
                }
            }
        }
        String temp1 = "";
        String temp2 = "";

        for(int i = 0; i < 12; i ++){
            if(count0[i] > count1[i]){
                temp1 += 0;
                temp2 += 1;
            }
            else {
                temp1 += 1;
                temp2 += 0 ;
            }
        }


        String gamma = "";
        String eps = "";
        System.out.println(temp1);
        System.out.println(temp2);

        // convert the two numbers and multiply 
        
        // System.out.println(gamma);
        // System.out.println(eps);
    }
}
