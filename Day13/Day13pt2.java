import java.io.*;
import java.util.*;

public class Day13pt2 {
    static boolean[][] grid = new boolean[1400][1400];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        //799
        for(int i = 0; i < 799; i ++) {
            String line = br.readLine();
            String[] tokens = line.split(",");
            grid[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])] = true;
        }
        System.out.println(checkTrue());
        reflectVertical(655);
        System.out.println(checkTrue());
        reflectHorizontal(447);
        System.out.println(checkTrue());
        reflectVertical(327);
        System.out.println(checkTrue());
        reflectHorizontal(223);
        System.out.println(checkTrue());
        reflectVertical(163);
        System.out.println(checkTrue());
        reflectHorizontal(111);
        System.out.println(checkTrue());
        reflectVertical(81);
        System.out.println(checkTrue());
        reflectHorizontal(55);
        System.out.println(checkTrue());
        reflectVertical(40);
        System.out.println(checkTrue());
        reflectHorizontal(27);
        System.out.println(checkTrue());
        reflectHorizontal(13);
        System.out.println(checkTrue());
        reflectHorizontal(6);
        System.out.println(checkTrue());



        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                if(grid[i][j]) {
                    pw.print("#");
                }
                else {
                    pw.print(".");
                }
            }
            pw.println("");
        }
        pw.close();
    }
    
    public static void reflectVertical(int number) {
        
        for(int i = number; i < 1400; i ++) {
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
        for(int j = 0; j < 1400; j ++) {
            for(int i = number; i < 1400; i ++) {
                int difference = Math.abs(number-i);
                if(grid[j][i]) {
                    // System.out.println("----");
                    // System.out.println("X: " + j);
                    // System.out.println("Y: " + i);
                    grid[j][i] = false;
                    grid[j][number-difference] = true;
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
