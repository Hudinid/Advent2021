import java.io.*;
import java.util.*;

public class Day13pt1 {
    static boolean[][] grid = new boolean[1400][1400];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        //799
        for(int i = 0; i < 18; i ++) {
            String line = br.readLine();
            String[] tokens = line.split(",");
            grid[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])] = true;
        }
        System.out.println(checkTrue());
        reflectVertical(655);
        System.out.println(checkTrue());
    }
    
    public static void reflectVertical(int number) {
        
        for(int i = number+1; i < 1400; i ++) {
            for(int j = 0; j < 1400; j ++) {
                int difference = Math.abs(number-i);
                if(grid[i][j]) {
                    grid[i][j] = false;
                    grid[number-difference][j] = true;
                }
            }
        }
    }

    public static void reflectHorizontal(int number) {
        for(int i = number+1; i < 1400; i ++) {
            for(int j = 0; j < 1400; j ++) {
                int difference = Math.abs(number-j);
                if(grid[j][i]) {
                    grid[j][i] = false;
                    grid[i][number - difference] = true;
                }
            }
        }
    }

    public static int checkTrue() {
        int temp = 0;
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                if(grid[i][j]) temp ++;
            }
        }
        return temp;
    }
}
