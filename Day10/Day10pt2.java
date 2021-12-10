package Day10;

import java.util.*;
import java.io.*;


public class Day10pt2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        ArrayList<ArrayList<Character>> missing = new ArrayList<ArrayList<Character>>();
        int ret = 0;
        for(int i = 0; i < 102; i ++) {
            String line = br.readLine(); 
            ArrayList<Character> currentOpen = new ArrayList<Character>();
            boolean good = true;
            for(int j = 0; j < line.length(); j ++) {
                int n = currentOpen.size();
                if(line.charAt(j) == '>') {
                    if(currentOpen.get(n-1) == '<') {
                        currentOpen.remove(n-1);
                    }
                    else {
                        good = false;
                        break;
                    }
                }
                else if(line.charAt(j) == ')') {
                    if(currentOpen.get(n-1) == '(') {
                        currentOpen.remove(n-1);
                    }
                    else {
                        good = false;
                        break;
                    }
                }
                else if(line.charAt(j) == ']') {
                    if(currentOpen.get(n-1) == '[') {
                        currentOpen.remove(n-1);
                    }
                    else {
                        good = false;
                        break;
                    }
                }
                else if(line.charAt(j) == '}') {
                    if(currentOpen.get(n-1) == '{') {
                       currentOpen.remove(n-1);
                    }
                    else {
                        good = false;
                        break;
                    }
                }
                else {
                    currentOpen.add(line.charAt(j));
                }
            }
            if(good && currentOpen.size() != 0) {
                missing.add(currentOpen);
            }
        }

        // ret = 0;
        ArrayList<Long> numbers = new ArrayList<Long>();
        // System.out.println("---------");
        // for(int i = 0; i < missing.size(); i ++){
        //     System.out.println(missing.get(i));
        // }

        for(int i = 0; i < missing.size(); i ++) {
            ArrayList<Character> chars = missing.get(i);
            long temp = 0;
            for(int j = chars.size()-1; j >= 0; j --) {
                temp *= 5;
                if(chars.get(j) == '(') {
                    temp += 1;
                }
                else if(chars.get(j) == '[') {
                    temp += 2;
                }
                else if(chars.get(j) == '{') {
                    temp += 3;
                }
                else if(chars.get(j) == '<') {
                    temp += 4;
                }
            }
            numbers.add(temp);
        }
        Collections.sort(numbers);
        System.out.println(numbers.get(numbers.size()/2));
        
        // System.out.println(ret);
    }
}