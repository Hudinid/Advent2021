package Day7;

import java.io.*;
import java.util.*;

public class Day7pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String[] tokens = line.split(",");
        ArrayList<Integer> numbers = new ArrayList<Integer>();


        int max = Integer.MIN_VALUE;
        for(int i = 0; i < tokens.length; i++){
            max = Math.max(max, Integer.parseInt(tokens[i]));
            numbers.add(Integer.parseInt(tokens[i]));
        }

        int min = Integer.MAX_VALUE;
        int temp = 0;
        for(int i = 0; i < max; i ++) {
            temp = 0;
            int spot  = i;
            for(int j = 0; j < numbers.size(); j ++){
                
                // int temp2 = calculate(Math.abs(numbers.get(j) - spot));
                // System.out.print(temp2 + " ");
                temp += calculate(Math.abs(numbers.get(j) - spot));
                
            }
            // System.out.println(temp); 
            // System.out.println("------------");
            min = Math.min(min, temp);
        }

        System.out.println(min);
    }

    public static int calculate(int number){
        int temp = 0;
        for(int i = 0; i <= number; i ++){
            temp += i;
        }
        return temp;
    }
}
