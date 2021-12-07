package Day6;

import java.io.*;
import java.util.*;

public class Day6Pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();

        String[] tokens = line.split(",");
        ArrayList<Integer> fish = new ArrayList<Integer>();

       
        
        for(int i = 0; i < tokens.length; i ++) {
            fish.add(Integer.parseInt(tokens[i]));
        }
        int addFish = 0;
        for(int i = 0; i < 256; i ++) {
            
            addFish = 0;
            for(int j = 0; j < fish.size(); j ++){
                fish.set(j, fish.get(j) - 1);
                if(fish.get(j) == 0) {
                    fish.set(j, 7);
                    addFish ++;
                }
            }

            for(int j = 0; j < addFish; j ++) {
                fish.add(9);
            }

        }
        
        System.out.println(fish.size() - addFish);
    }    
}

