package Day6;

import java.io.*;
import java.util.*;

public class Day6Pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();

        String[] tokens = line.split(",");
        HashMap<Integer, Long> fish = new HashMap<Integer, Long>();
        
        
       
        long result = 0;
        fish.put(-1, result);
        fish.put(0, result);
        fish.put(1, result);
        fish.put(2, result);
        fish.put(3, result);
        fish.put(4, result);
        fish.put(5, result);
        fish.put(6, result);
        fish.put(7, result);
        fish.put(8, result);
        
        for(int i = 0; i < tokens.length; i ++) {
            // System.out.println(fish.get(Integer.parseInt(tokens[i])));
            fish.put(Integer.parseInt(tokens[i]), fish.get(Integer.parseInt(tokens[i]))+1);
        }
        
        for(int i = 0; i < 256; i ++) {
        
            for(int j = 0; j < 9; j ++){
                fish.put(j-1, fish.get(j));
            }
            fish.put(8, fish.get(-1));
            fish.put(6, fish.get(-1) + fish.get(6));
        }

        for(int i = 0; i < 9; i ++) {
            result += fish.get(i);
        }
        System.out.println(result);
    }    
}

