package Day3;
import java.util.*;
import java.io.*;
public class Day3Pt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        
        ArrayList<String> numbers2 = new ArrayList<String>();
        ArrayList<String> numbers3 = new ArrayList<String>();
        String[] numbers = new String[1000];
        for(int i = 0; i < 1000; i ++){ 
            numbers[i] = br.readLine();
            
        }
        for(int i = 0; i < 1000; i ++){
            numbers2.add(numbers[i]);
            numbers3.add(numbers[i]);
        }
        
        int[] count0 = new int[12];
        int[] count1 = new int[12];

        for(int i = 0; i < 1000; i ++){
            for(int j = 0; j < 12; j ++) {
                if(Integer.parseInt(String.valueOf(numbers[i].charAt(j))) == 0){
                    count0[j] ++;
                }
                else {
                    count1[j] ++;
                }
            }
        }
        String gamma = "";
        String eps = "";

        for(int i = 0; i < 12; i ++){
            if(count0[i] > count1[i]){
                gamma += 0;
                eps += 1;
            }
            else {
                gamma += 1;
                eps += 0 ;
            }
        }

        
        int size = 1000;
        int index = 0;
        ArrayList<String> tempArray1 = new ArrayList<String>();
        ArrayList<String> tempArray2 = new ArrayList<String>();
        while(size != 1) {
            int oxygen = findGamma(index, numbers2);
            

            for(int i = 0; i < numbers2.size(); i ++) {
                if(Integer.parseInt(String.valueOf(numbers2.get(i).charAt(index))) == oxygen) {
                    tempArray1.add(numbers2.get(i));           
                }
            }

            size = tempArray1.size();
            numbers2 = new ArrayList<String>(tempArray1);
            tempArray1.clear();
            index ++;
        }

        size = 1000;
        index = 0;
        while(size != 1) {
            int oxygen = findGamma(index, numbers3);
            int carbon = oxygen == 1 ? 0 : 1;

            for(int i = 0; i < numbers3.size(); i ++) {
                if(Integer.parseInt(String.valueOf(numbers3.get(i).charAt(index))) == carbon) {
                    tempArray2.add(numbers3.get(i));           
                }
            }

            size = tempArray2.size();
            numbers3 = new ArrayList<String>(tempArray2);
            tempArray2.clear();
            index ++;
        }

        System.out.println("---");
        System.out.println(numbers2.get(0));
        System.out.println(numbers3.get(0));

    }

    public static int findGamma(int index, ArrayList<String> numbers) {
        int ones = 0;
        int zeros = 0;
        for(int i = 0; i < numbers.size(); i ++){
            if(Integer.parseInt(String.valueOf(numbers.get(i).charAt(index))) == 1) {
                ones ++;
            }
            else {
                zeros ++;
            }
        }
        return ones >= zeros ? 1 : 0;
    }
}
