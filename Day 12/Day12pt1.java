package Day12;

import java.util.*;
import java.io.*;

public class Day12pt1 {
    static ArrayList<Tile> allTiles = new ArrayList<Tile>();
    static ArrayList<Integer> numOfSmallCaves = new ArrayList<Integer>();
    
    public static ArrayList<ArrayList<Tile>> allPaths = new ArrayList<ArrayList<Tile>>();

    static int startIndex;
    static int ret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 2; i++){ // get input
            String line = br.readLine();
            String[] tokens = line.split("-");
            Tile temp = new Tile(tokens[0]);
            Tile temp2 = new Tile(tokens[1]);   
            addToList(temp, temp2); 
        }
        /*
start-A
start-b
A-c
A-b
b-d
A-end
b-end
*/
        // Checking list
        // for(int i = 0; i < allTiles.size(); i++) { 
            // allTiles.get(1).checkPaths();
        // }
        ArrayList<Tile> temp = new ArrayList<Tile>();
        System.out.println(allTiles.get(startIndex).getName());
        System.out.println("-------");
        // System.out.println(allTiles.get(5).getName());
        // allTiles.get(0).search(allTiles.get(0), temp);
        // allTiles.get(startIndex).search(allTiles.get(startIndex), temp);
        allTiles.get(0).search(allTiles.get(0), temp);
        // for(int i = 0; i < allPaths.size(); i ++){
        //     for(int j = 0; j < allPaths.get(i).size(); j++){
        //         System.out.print(allPaths.get(i).get(j).getName() + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(allPaths.size());
    }

    public static void addToList(Tile word, Tile word2){
        boolean alrExists1 = false;
        boolean alrExists2 = false;
        for(int i = 0; i < allTiles.size(); i ++) {
            if(word.getName().equals(allTiles.get(i).getName())){
                alrExists1 = true;
                allTiles.get(i).addPath(word2);
            }
            if(word2.getName().equals(allTiles.get(i).getName())) {
                alrExists2 = true;
                allTiles.get(i).addPath(word2);
            }
        }
        if(!alrExists1){
            if(word.getName().equals("start")) startIndex = allTiles.size();
            word.addPath(word2);
            allTiles.add(word);
        } 
        if(!alrExists2) {
            if(word2.getName().equals("start")) startIndex = allTiles.size();
            word2.addPath(word);
            allTiles.add(word2);
        }
    }

}


class Tile {
    private Tile prev;
    private ArrayList<Tile> openPaths = new ArrayList<Tile>();
    private String name;
    public Tile(String name, Tile initPath){
        this.name = name;
        this.openPaths.add(initPath);
    }

    public Tile(String name){
        this.name = name;
    }

    public void addPath(Tile tile) {
        this.openPaths.add(tile);
    }

    public String getName(){
        return this.name;
    }

    public void checkPaths() {
        System.out.print("Path " + this.getName() + " connects to: ");
        for(int i = 0; i < this.openPaths.size(); i ++) {
            System.out.print(this.openPaths.get(i).getName() + " ");
        }
        System.out.println();
    }

    public ArrayList<Tile> getPaths() {
        return this.openPaths;
    }
    public void search(Tile tile, ArrayList<Tile> currPath) {
        
        currPath.add(tile);

        if(tile.getName().equals("end")) {
            System.out.println("hellowasd");
            Day12pt1.allPaths.add(currPath);
            return;
        }

        for(int i = 0; i < this.openPaths.size(); i ++) {
            // System.out.println(openPaths.get(i).getName());
            if(currPath.size()>1) if(currPath.get(currPath.size()-2).getName().equals(this.openPaths.get(i).getName()) && Character.isLowerCase(currPath.get(currPath.size()-2).getName().charAt(0))){
                System.out.println("hi");
                continue;
            }
            if(openPaths.get(i).getName().equals("start")){ 
                System.out.println("hello");
                continue;
            }
            // System.out.println(openPaths.get(i).getName());
            // if(openPaths.get(i).getName().equals("end")) search(this.openPaths.get(i), currPath);
            search(this.openPaths.get(i), currPath);
            // return;
        }
    }
}
