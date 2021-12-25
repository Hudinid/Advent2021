package Day7;

import java.io.*;
import java.util.*;

public class Day7pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String[] tokens = line.split(",");
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for(int i = 0; i < tokens.length; i++){
            numbers.add(Integer.parseInt(tokens[i]));
        }
        int min = Integer.MAX_VALUE;
        int temp = 0;
        for(int i = 0; i < numbers.size(); i ++) {
            temp = 0;
            int spot = numbers.get(i);
            for(int j = 0; j < numbers.size(); j ++){
                temp += Math.abs(numbers.get(j) - spot);
            }
            min = Math.min(min, temp);
        }
        System.out.println(min);
    }

}
