package Day9;
import java.util.*;
import java.io.*;


public class Day9pt2 {

    static int basinSum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> basins = new ArrayList<Integer>();
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

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] != 9) {
                    basinSum = 0;
                    search(map, i, j);
                    basins.add(basinSum);
                }
            }
        }
        Collections.sort(basins);

        System.out.println(basins.get(basins.size()-1));
        System.out.println(basins.get(basins.size()-2));
        System.out.println(basins.get(basins.size()-3));
    }

    static void search(int[][] map, int i, int j) {
        map[i][j] = 9;
        if(j != 99 && map[i][j+1] != 9) search(map, i, j+1);
        if(j != 0 && map[i][j-1] != 9) search(map, i, j-1);
        if(i != 0 && map[i-1][j] != 9) search(map, i-1, j);
        if(i != 99 && map[i+1][j] != 9) search(map, i+1, j);
        basinSum++;
    }
}