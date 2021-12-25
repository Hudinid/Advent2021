package Day11;

import java.util.*;
import java.io.*;
public class Day11pt2 {

    static int[][] octopuses = new int[10][10];
    static ArrayList<Integer> setToZeroX = new ArrayList<Integer>();
    // static ArrayList<Integer> setToZeroY = new ArrayList<Integer>();

    static int ret = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        
        
        for(int i = 0; i < 10; i ++) {
            String line = br.readLine();
            String[] tokens = line.split("");
            for(int j = 0; j < tokens.length;j ++) {
                octopuses[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        boolean temp = false;
        int count = 0;
        while(!temp){
            count ++;
            setToZeroX.clear();
            flash();
            checkAll();
            if(setToZeroX.size() == 100) temp = true;
            correctAll();

        }

        System.out.println(count);
    }

    public static void correctAll() {
        for(int i = 0;i < 10; i ++){
            for(int j = 0; j < 10; j ++) {
                if(octopuses[i][j] < 0) {
                    octopuses[i][j] = 0;
                }
            }
        }
    }
    public static void flash() {
        for(int i = 0; i < 10; i ++){
            for(int j = 0; j < 10; j ++){
                octopuses[i][j] ++;
            }
        }
    }

    public static void checkAll() {
        for(int i = 0; i < 10; i ++) {
            for(int j = 0; j < 10; j ++) {
                surge(i, j);
            }
        }
    }

    public static void surge(int i, int j) {
        if(octopuses[i][j] > 9) {
            ret++;
            octopuses[i][j] = Integer.MIN_VALUE;
            setToZeroX.add(i);
            // setToZeroY.add(j);
            if(i == 0 && j == 0) { // top left
                octopuses[i+1][j] += 1;
                if(octopuses[i+1][j] > 9) surge(i+1, j);
                octopuses[i][j+1] += 1;
                if(octopuses[i][j+1] > 9) surge(i+1, j);
                octopuses[i+1][j+1] += 1;
                if(octopuses[i][j+1] > 9) surge(i+1, j);
                return;
            }
            if(i == 0 && j == 9) { // top right
                octopuses[i][j-1] += 1;
                if(octopuses[i][j-1] > 9) surge(i, j-1);
                octopuses[i+1][j] += 1;
                if(octopuses[i+1][j] > 9) surge(i+1, j);
                octopuses[i+1][j-1] += 1;
                if(octopuses[i+1][j] > 9) surge(i+1, j);
                return;
            }

            if(i == 9 && j == 0){ // bottom left
                octopuses[i][j+1] += 1;
                if(octopuses[i][j+1] > 9) surge(i, j + 1);
                octopuses[i-1][j] += 1;
                if(octopuses[i-1][j] > 9) surge(i-1, j);
                octopuses[i-1][j+1] += 1;
                if(octopuses[i-1][j+1] > 9) surge(i-1, j+1);
                return;
            }
            
            if(i == 9 && j == 9){// bottom right
                octopuses[i][j-1] += 1;
                if(octopuses[i][j-1] > 9) surge(i, j-1);
                octopuses[i-1][j-1] += 1;
                if(octopuses[i-1][j-1] > 9) surge(i-1, j-1);
                octopuses[i-1][j] += 1;
                if(octopuses[i-1][j] > 9) surge(i-1, j);
                return;
            } 

            if(i == 0){ // top
                octopuses[i][j-1] ++;
                octopuses[i][j+1] ++;
                octopuses[i+1][j-1] ++;
                octopuses[i+1][j] ++;
                octopuses[i+1][j+1] ++;
                if(octopuses[i][j-1] > 9) surge(i, j-1);
                if(octopuses[i][j+1] > 9) surge(i, j+1);
                if(octopuses[i+1][j-1] > 9) surge(i, j+1);
                if(octopuses[i+1][j] > 9) surge(i+1,j);
                if(octopuses[i+1][j+1] > 9) surge(i+1,j+1);
                return;
            }

            if(i == 9) { // bottom
                octopuses[i][j-1]++;
                octopuses[i][j+1]++;
                octopuses[i-1][j]++;
                octopuses[i-1][j-1]++;
                octopuses[i-1][j+1]++;

                if(octopuses[i][j-1] > 9) surge(i, j-1);
                if(octopuses[i][j+1] > 9) surge(i, j+1);
                if(octopuses[i-1][j] > 9) surge(i-1, j);
                if(octopuses[i-1][j-1] > 9) surge(i-1, j+1);
                if(octopuses[i-1][j+1] > 9) surge(i-1, j+1);
                return;
            }

            if(j == 0) { // left
                octopuses[i][j+1] ++;
                octopuses[i-1][j] ++;
                octopuses[i-1][j+1] ++;
                octopuses[i+1][j] ++;
                octopuses[i+1][j+1] ++;

                if(octopuses[i][j+1] > 9) surge(i, j+1);
                if(octopuses[i-1][j] > 9) surge(i-1, j);
                if(octopuses[i-1][j+1] > 9) surge(i-1, j+1);
                if(octopuses[i+1][j] > 9) surge(i+1, j);
                if(octopuses[i+1][j+1] > 9) surge(i+1, j+1);
                return;
            }

            if(j == 9){// right
                octopuses[i-1][j] ++;
                octopuses[i-1][j-1] ++;
                octopuses[i][j-1] ++;
                octopuses[i+1][j-1] ++;
                octopuses[i+1][j] ++;
                if(octopuses[i-1][j] > 9) surge(i-1, j);
                if(octopuses[i-1][j-1] > 9) surge(i-1, j-1);
                if(octopuses[i][j-1] > 9) surge(i, j-1);
                if(octopuses[i+1][j-1] > 9) surge(i+1, j-1);
                if(octopuses[i+1][j] > 9) surge(i+1, j-1);
                return;
            }
            
            octopuses[i-1][j-1] ++;
            octopuses[i-1][j] ++;
            octopuses[i-1][j+1] ++;
            octopuses[i][j-1] ++;
            octopuses[i][j+1] ++;
            octopuses[i+1][j-1] ++;
            octopuses[i+1][j] ++;
            octopuses[i+1][j+1] ++;
            if(octopuses[i-1][j-1] > 9) surge(i-1, j-1);
            if(octopuses[i-1][j] > 9) surge(i-1, j);
            if(octopuses[i-1][j+1] > 9) surge(i-1, j+1);
            if(octopuses[i][j-1] > 9) surge(i, j-1);
            if(octopuses[i][j+1] > 9) surge(i, j+1);
            if(octopuses[i+1][j-1] > 9) surge(i+1, j-1);
            if(octopuses[i+1][j] > 9) surge(i+1, j);
            if(octopuses[i+1][j+1] > 9) surge(i+1, j+1);
        }
    }
}
