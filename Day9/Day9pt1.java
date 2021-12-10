package Day9;
import java.util.*;
import java.io.*;

public class Day9pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int ret = 0;
        String line = br.readLine();
        int[][] map = new int[100][line.length()];
        String[] tokens = line.split("");
        for(int i = 0 ; i < line.length(); i ++) {
            map[0][i] = Integer.parseInt(tokens[i]);
        }

        for(int i = 1; i < 100; i ++) {
            line = br.readLine();
            tokens = line.split("");
            for(int j = 0; j < tokens.length; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        for(int i = 0; i < 100; i ++) {
            for(int j = 0; j < map[i].length; j ++) {
                int curr = map[i][j];
                if(j == 0) { // on left side
                    if(i == 0) { // top left corner
                        if(map[i+1][j] > curr && map[i][j+1] > curr) {
                            ret += curr+1;
                        }
                        continue;
                    }
                    if(i == 99) { //bottom left corner
                        if(map[i-1][j] > curr && map[i][j+1] > curr) {
                            ret += curr+1;
                        }
                        continue;
                    }

                    if(map[i-1][j] > curr && map[i+1][j] > curr && map[i][j+1] > curr) { //every other on left hand side
                        ret += curr+1;
                    }
                    continue;
                }

                if(j == map[i].length-1) { //on right hand side
                    if(i == 0) { //top right corner
                        if(map[i][j-1] > curr && map[i+1][j] > curr) {
                            ret += curr+1;
                        }
                        continue;
                    }
                    if(i == 99) { //bottom right corner
                        if(map[i-1][j] > curr && map[i][j-1] > curr) {
                            ret += curr+1;
                        }
                        continue;
                    }
                    
                    if(map[i-1][j] > curr && map[i][j-1] > curr && map[i+1][j] > curr) { //right hand side
                        ret += curr + 1;
                        
                    }
                    continue;
                }

                if(i == 0) { //top side
                    if(map[i][j-1] > curr && map[i][j+1] > curr && map[i+1][j] > curr) {
                        ret += curr+1;
                    }
                    continue;
                }

                if(i == 99) { //bottom side
                    if(map[i-1][j] > curr && map[i][j-1] > curr && map[i][j+1] > curr) { 
                        ret += curr+1;
                    }
                    continue;
                }
                // System.out.println("-----");
                // System.out.println("i - " + i);
                // System.out.println("j - " + j);
                if(map[i-1][j] > curr && map[i+1][j] > curr && map[i][j-1] > curr && map[i][j+1] > curr) { //stars
                    ret += curr+1;
                    continue;
                }
            }
        }

        System.out.println(ret);
    }
}
