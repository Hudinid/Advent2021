import java.io.*;
import java.util.*;


public class Day14pt2 {
    static HashMap<String, String> codes = new HashMap<>();
    static HashMap<String, Long> counter = new HashMap<>();
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
            counter.put(catalyst, (long) 0);
        }

        int length = line.length();
        for(int i = 0; i < line.length()-1; i ++) { 
            String searched = line.substring(i, i+2);
            counter.put(searched, counter.get(searched)+1);
        }

        for(int i = 0; i < 40; i ++) {
            applyConversion();
        }
        findLowHigh(line);

    }
    public static void applyConversion() {
        HashMap<String, Long> temp = new HashMap<>(counter);
        for(String i : counter.keySet()) {
            char firstChar = i.charAt(0);
            char secondChar = i.charAt(1);
            String added = codes.get(i);
            for(int j = 0; j < counter.get(i); j ++) {
                temp.put(firstChar+added, temp.get(firstChar+added)+1);
                
            }
            temp.put(i, (long) 0); 
        }
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