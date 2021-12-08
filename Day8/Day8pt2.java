package Day8;
import java.util.*;
import java.io.*;

public class Day8pt2 {
    static String zero = "";
    static String one = "";
    static String two = "";
    static String three = "";
    static String four = "";
    static String five = "";
    static String six = "";
    static String seven = "";
    static String eight = "";
    static String nine = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        //acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf
        //2, 4, 3, 7
        int ret = 0;
        for(int i = 0; i < 200; i ++){
            // System.out.println(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] signalPatterns = new String[10];
            String[] words = new String[4];
            int count = 0;
            int count2 = 0;
            zero = "";
            one = "";
            two = "";
            three = "";
            four = "";
            five = "";
            six = "";
            seven = "";
            eight = "";
            nine = "";
            for(int j = 0; j < 10; j ++) {
                String line = st.nextToken();
                if(line.length() == 2){
                    one = line;
                }
                if(line.length() == 3){
                    seven = line;
                }
                if(line.length() == 4){
                    four = line;
                }
                if(line.length() == 7){
                    eight = line;
                }
                signalPatterns[j] = line;
            }
            st.nextToken();
            for(int j = 0; j < 4; j ++){
                words[j] = st.nextToken();
            }
            
            findNine(signalPatterns);
            findSixAndZero(signalPatterns);
            findThree(signalPatterns);
            findTwoAndFive(signalPatterns);
            String temp = "";
            for(int j = 0; j < 4; j ++) {
                if(checkEqual(words[j], zero)) temp += "0";
                if(checkEqual(words[j], one)) temp += "1";
                if(checkEqual(words[j], two)) temp += "2";
                if(checkEqual(words[j], three)) temp += "3";
                if(checkEqual(words[j], four)) temp += "4";
                if(checkEqual(words[j], five)) temp += "5";
                if(checkEqual(words[j], six)) temp += "6";
                if(checkEqual(words[j], seven)) temp += "7";
                if(checkEqual(words[j], eight)) temp += "8";
                if(checkEqual(words[j], nine)) temp += "9";
            }
            ret += Integer.parseInt(temp);
        }
        

        pw.println(ret);
        pw.close();
    }
    static void findNine(String[] signalPatterns){
        String temp = combineCodes(seven, four); 
        for(int i = 0; i < signalPatterns.length; i ++) {
            // System.out.println("hit");
            String word = signalPatterns[i];
            
            String temp2 = "";
            if(word.length() != 6) continue;
            // System.out.println(word);

            temp2 = missingCharacters(word, temp);
            
            if(temp2.length() == 1) {
                // System.out.println("HELLO");
                nine = temp + temp2;
                // System.out.println(nine);
                return;
            }
        }
    }

    static void findSixAndZero(String[] signalPatterns) {
        
        for(int i = 0; i < signalPatterns.length; i ++){
            String word = signalPatterns[i];
            String temp2 = "";
            if(word.length() != 6) continue;
            if(checkEqual(word, nine)) continue;
            // System.out.println(checkEqual(word,nine));
            temp2 = combineCodes(word, one);
            if(checkEqual(eight, temp2)){
                 six = word;
            }
            else {
                zero = word;
            }
        }
    }

    static void findThree(String[] signalPatterns) {
        String temp = one;
        for(int i = 0; i < signalPatterns.length; i ++) {
            String word = signalPatterns[i];
            String temp2 = "";
            if(word.length() != 5) continue;
            temp2 = missingCharacters(word, one);
            if(temp2.length() == 3) {
                three = combineCodes(temp2, one);
            }
        }
    }

    static void findTwoAndFive(String[] signalPatterns) {
        String temp = six;
        for(int i = 0; i < signalPatterns.length; i ++) {
            String word = signalPatterns[i];
            String temp2 = "";
            if(word.length() != 5) continue;
            if(checkEqual(word, three)) continue;
            // System.out.println("Word: " + word);
            temp2 = missingCharacters(word, temp);
            // System.out.println(temp2);
            // System.out.println(nine.indexOf(temp2));
            if(temp2.length() == 0){
                five = word;
            }
            else {
                two = word;
            }
        }
    }
    static String combineCodes(String line1, String line2) {
        String ret = line1;

        for(int i = 0; i < line2.length(); i++) {
            char addedChar = line2.charAt(i);
            boolean willAdd = true;
            for(int j = 0; j < ret.length(); j++) {
                if(ret.charAt(j) == addedChar) {
                    willAdd = false;
                }
            }
            if(willAdd) ret += addedChar;
        }
        // System.out.println("****");
        // System.out.println(ret);
        // System.out.println("*****");
        return ret;
    }

    static boolean checkEqual(String line1, String line2) {
        if(line1.length() != line2.length()) return false;
        for(int i = 0; i < line1.length(); i ++) {
            char checkedChar = line1.charAt(i);
            boolean temp = false;
            for(int j = 0; j < line2.length(); j ++) {
                if(checkedChar == line2.charAt(j)){
                    temp = true;
                }
            }
            if(!temp) return false;
        }
        return true;
    }

    static String missingCharacters(String line1, String line2) {
        String ret = "";
        for(int i = 0; i < line1.length(); i ++){
            String checkedChar = line1.substring(i,i+1);
            if(line2.indexOf(checkedChar) == -1) {
                ret += checkedChar;
            }
        }
        return ret; 
    }
}
