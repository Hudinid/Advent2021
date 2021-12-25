package Day10;

import java.util.*;
import java.io.*;


public class Day10pt1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        // ArrayList<String> illegalChars = new ArrayList<String>();
        int ret = 0;
        for(int i = 0; i < 102; i ++) {
            String line = br.readLine(); 
            ArrayList<Character> currentOpen = new ArrayList<Character>();

            for(int j = 0; j < line.length(); j ++) {
                int n = currentOpen.size();
                if(line.charAt(j) == '>') {
                    if(currentOpen.get(n-1) == '<') {
                        currentOpen.remove(n-1);
                    }
                    else {
                        ret += 25137;
                        break;
                    }
                }
                else if(line.charAt(j) == ')') {
                    if(currentOpen.get(n-1) == '(') {
                        currentOpen.remove(n-1);
                    }
                    else {
                        ret += 3;
                        break;
                    }
                }
                else if(line.charAt(j) == ']') {
                    if(currentOpen.get(n-1) == '[') {
                        currentOpen.remove(n-1);
                    }
                    else {
                        ret += 57;
                        break;
                    }
                }
                else if(line.charAt(j) == '}') {
                    if(currentOpen.get(n-1) == '{') {
                       currentOpen.remove(n-1);
                    }
                    else {
                        ret += 1197;
                        break;
                    }
                }
                else {
                    currentOpen.add(line.charAt(j));
                }
            }
        }
        System.out.println(ret);
    }
}