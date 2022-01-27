import java.io.*;
import java.util.*;


public class Day14pt1 {
    static HashMap<String, String> codes = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String line = st.nextToken();
        br.readLine();
        

        for(int i = 0; i < 100; i ++) {
            st = new StringTokenizer(br.readLine());
            String catalyst = st.nextToken(); //left of arrow
            st.nextToken(); //skip arrow
            String converted = st.nextToken(); //right of arrow
            codes.put(catalyst, converted);
        }

        for(int i = 0; i < 10; i ++) {
            // System.out.println(line);
            line = applyConversion(line);
        }
        findLowHigh(line);
    }
    public static String applyConversion(String line) {
        String temp = "";
        for(int i = 0 ; i < line.length()-1; i ++) {
            String searched = line.substring(i, i+2);
            // System.out.println("---");
            // System.out.println(searched);
            temp += line.charAt(i);
            if(codes.containsKey(searched)) {
                temp += codes.get(searched);
            }
            else {
                temp += searched;
            }
        }
        temp += line.charAt(line.length()-1);
        return temp;
    }

    public static void findLowHigh(String word) {
        HashMap<Character, Long> map = new HashMap<>();
        char high;
        char low;
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        for(int i = 0; i < word.length(); i ++) {
            char letter = word.charAt(i);
            if(map.containsKey(letter)) {
                map.put(letter, map.get(letter)+1);
            }
            else {
                map.put(letter,(long) 1);
            }
        }

        for(char i : map.keySet()) {
            max = Math.max(map.get(i), max);
            min = Math.min(map.get(i), min);
        }
        System.out.println("MAX: " + max);
        System.out.println("MIN: " + min);
        System.out.println("MAX - MIN: " + (max-min));
    }
}