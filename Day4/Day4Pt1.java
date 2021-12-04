package Day4;

import java.util.*;
import java.io.*;

public class Day4Pt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        ArrayList<int[][]> boards = new ArrayList<int[][]>();
        int[] order;
        String line = br.readLine();
        String[] tokens = line.split(",");
        order = new int[tokens.length];

        for(int i = 0; i < tokens.length; i ++) {
            order[i] = Integer.parseInt(tokens[i]);
        }
        
        
        for(int i = 0; i < 100; i ++){
            int row = 0;
            int col = 0;
            int[][] tempBoard = new int[5][5];
            br.readLine();
            for(int j = 0; j < 5; j ++){
                col = 0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 5; k ++) {
                    tempBoard[row][col] = Integer.parseInt(st.nextToken());
                    col ++;
                }
                row ++;
            }
            boards.add(tempBoard);
            row = 0;
            col = 0;
        }

        ArrayList<int[][]> backBoard = new ArrayList<int[][]>(boards);
        boolean haha = false;
        int count = 0;
        while(haha == false) {
            int number = order[count];
            boards = doBoard(number, boards);
            
            checkBingo(boards);
            count ++;
            System.out.println("Number: " + number);
        }
        // System.out.println(number);
        printSum(boards.get(25));
    }

    public static void printSum(int[][] board) {
        int sum  = 0;
        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 5; j ++) {
                System.out.print(board[i][j] + " ");
                if(board[i][j] != 100) sum += board[i][j];
            }
            System.out.print("\n");
        }
        System.out.println("-----");
        System.out.println("Sum: " + sum);
    }

    public static ArrayList<int[][]> doBoard(int number, ArrayList<int[][]> boards) {
        for(int i = 0; i < boards.size(); i ++) {
            int[][] tempBoard = new int[5][5];
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k ++) {
                    if(boards.get(i)[j][k] == number) {
                        tempBoard[j][k] = 100;
                    }
                    else {
                        tempBoard[j][k] = boards.get(i)[j][k];
                    }
                }
            }
            boards.set(i, tempBoard);
        }
        return boards;
    }

    public static boolean checkBingo(ArrayList<int[][]> boards){
        for(int i = 0; i < boards.size(); i ++) {
            for(int j = 0; j < 5; j ++) {
                if(boards.get(i)[j][0] == boards.get(i)[j][1] && boards.get(i)[j][1] == boards.get(i)[j][2] && boards.get(i)[j][1] == boards.get(i)[j][3] && boards.get(i)[j][1] == boards.get(i)[j][4]){
                    System.out.println("---");
                    System.out.println("Board: " + i);
                    System.out.println("Row: " + j);
                    return true;
                }
            }
            for(int j = 0; j < 5; j ++) {
                if(boards.get(i)[0][j] == boards.get(i)[1][j] && boards.get(i)[0][j] == boards.get(i)[2][j] && boards.get(i)[0][j] == boards.get(i)[3][j] && boards.get(i)[0][j] == boards.get(i)[4][j]) {
                    System.out.println("---");
                    System.out.println("Board: " + i);
                    System.out.println("Column: " + j);
                    return true;
                }
            }
        }
        return false;
    }
}
